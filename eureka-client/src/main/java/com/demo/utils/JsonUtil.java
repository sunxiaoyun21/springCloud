package com.demo.utils;

import com.demo.utils.BusinessException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
@Slf4j
@ConditionalOnClass(ObjectMapper.class)
public class JsonUtil {
    @Getter
    private static ObjectMapper objectMapper = null;

    public JsonUtil(ObjectMapper objectMapper) {
        log.info("JsonUtils配置成功");
        JsonUtil.objectMapper = objectMapper;
    }

    /**
     * 将集合类型json字符串转换为java对象
     */
    public static <T> T jsonToList(String json, Class<T> elementClass) {
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, elementClass);
        try {
            return objectMapper.readValue(json, javaType);
        } catch (IOException e) {
            log.warn(e.getMessage());
            throw new BusinessException("JSON序列化异常");
        }
    }

    /**
     * 简单json对象序列化为java对象
     */
    public static <T> T jsonToObject(String json, Class<T> elementClass) {
        try {
            return objectMapper.readValue(json, elementClass);
        } catch (IOException e) {
            log.warn(e.getMessage());
            throw new BusinessException("JSON序列化异常");
        }
    }

    /**
     * 简单java对象转json
     */
    public static String objectToJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (IOException e) {
            log.warn(e.getMessage());
            throw new BusinessException("JSON序列化异常");
        }
    }
}
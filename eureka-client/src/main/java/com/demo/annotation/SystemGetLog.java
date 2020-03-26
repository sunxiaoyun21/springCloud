package com.demo.annotation;

import java.lang.annotation.*;

/**
 * @author sunxiaoyun
 * @date 2020/3/24 16:08
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemGetLog {

    /**
     * 对象名
     *
     * @return
     */
    String objectName() default "";

    /**从页面参数中解析出要查询的id，
     * 如域名修改中要从参数中获取customerDomainId的值进行查询
     */
    String parameterKey() default "";


    String value() default "";

}

package com.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 定义一个方法级别的@SystemLog注解，用于标注需要监控的方法：
 * @author sunxiaoyun
 * @date 2020/3/18 11:44
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SystemLog {

    String value() default "";

}

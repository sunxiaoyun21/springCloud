package com.demo.others;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 孙小云
 * @version 1.0
 * @date 2019/11/12 13:31
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER,ElementType.METHOD})
public @interface MainAnnotation {

    int maintype() default 0;
    String type() default "0";
    String tables() default "";
    String desc() default "";
}

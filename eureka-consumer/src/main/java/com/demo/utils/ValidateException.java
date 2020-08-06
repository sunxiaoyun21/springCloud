package com.demo.utils;

import java.io.Serializable;

/**
 * 用户自定义异常，只打印异常信息，不打印堆栈信息
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/2 17:57
 **/
public class ValidateException extends RuntimeException implements Serializable {
    public ValidateException(String message) {
        super(message);
    }

    public ValidateException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidateException(Throwable cause) {
        super(cause);
    }
}

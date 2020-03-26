package com.demo.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author sunxiaoyun
 * @date 2020/3/26 11:00
 */
@Builder
@Setter
@Getter
@Accessors(chain = true)
public  class Result {
    private String field;
    private Object oldValue;
    private Object newValue;
}

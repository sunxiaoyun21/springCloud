package com.demo.utils;

import org.springframework.util.Assert;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author 孙小云
 * @version 1.0
 * @date 2019/9/17 15:08
 **/
public class OtherUtil {

    /**
     * 产生随机数(纯数字)
     */
    public static int random(int length) {
        Assert.isTrue(length > 0 && length < 9, "长度范围(1-8)");
        int start = (int) Math.pow(10, length - 1);
        int end = (int) Math.pow(10, length);
        ThreadLocalRandom random = ThreadLocalRandom.current();
        return random.nextInt(start, end);
    }


}

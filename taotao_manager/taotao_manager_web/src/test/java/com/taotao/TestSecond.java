package com.taotao;

import org.junit.Test;

/**
 * 商品的id不用自增主键
 * 用当前的毫秒数+两位随机数  并发数不能太高
 * 还可以选nanoTime()
 */
public class TestSecond {
    @Test
    public void testSecond(){
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println (currentTimeMillis);
    }
}

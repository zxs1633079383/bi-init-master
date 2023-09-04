package com.yupi.springbootinit.manager;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class RedisLimiterMangerTest {

    @Resource
    private RedisLimiterManger redisLimiterManger;

    @Test
    void doRateLimit() {
        redisLimiterManger.doRateLimit("123");
    }

}
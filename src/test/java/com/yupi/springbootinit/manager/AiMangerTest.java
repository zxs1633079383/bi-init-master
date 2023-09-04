package com.yupi.springbootinit.manager;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class AiMangerTest {

    @Resource
    private  AiManger aiManger;

    @Test
    void doChar() {
        String result = aiManger.doChar(1659171950288818178L,"你是一名数据分析师,接下来我会给你我的分析目标和原始数据,请告诉我分析结论\n" +
                "分析目标:分析结论\n" +
                "数据: 日期,人数\n" +
                "1号,10\n" +
                "2号,20\n" +
                "3号,30\n" +
                "4号,40\n" +
                "\n" +
                " ");
        System.out.println(result);
    }
}
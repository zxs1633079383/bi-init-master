package com.yupi.springbootinit.mapper;

import com.yupi.springbootinit.model.entity.Chart;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class ChartMapperTest {

    @Resource
    private ChartMapper chartMapper;

    @Test
    void queryChartData() {
        String id = "9";
        List<Map<String, Object>> maps = chartMapper.queryChartData("select * from chart_" + id);
        maps.toArray();
    }
}
package com.yupi.springbootinit.model.dto.chart;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 创建请求
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 * @from <a href="https://yupi.icu">编程导航知识星球</a>
 */
@Data
public class ChartAddRequest implements Serializable {

    /**
     * 分析目标
     */
    private String goal;

    private String name;

    /**
     * 原始分析数据
     */
    private String chartData;

    /**
     * 图表数据
     */
    private String chartType;



}
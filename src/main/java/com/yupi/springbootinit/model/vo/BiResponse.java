package com.yupi.springbootinit.model.vo;


import lombok.Data;

/***
 * BI的返回结果
 */
@Data
public class BiResponse {

    //AI代码
    private String analyzeCode;

    //AI结论
    private String analyzeResult;

    //图表ID
    private Long chartId;

}

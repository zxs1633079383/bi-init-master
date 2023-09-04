package com.yupi.springbootinit.utils;


import cn.hutool.core.collection.CollUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/***
 * Excel数据转换为Csv格式..
 */
@Component
@Slf4j
public class ExcelUtils {

    public static String excelToCsv(MultipartFile multipartFile){
        File file = null;
        List<Map<Integer,String>> list = null;
        try {
//            file = ResourceUtils.getFile("classpath:test_data.xlsx");
//            list = EasyExcel.read(file)
            list = EasyExcel.read(multipartFile.getInputStream())
                    .excelType(ExcelTypeEnum.XLSX)
                    .sheet(0)
                    .headRowNumber(0)
                    .doReadSync();


        } catch (IOException e) {
            log.error("表格操作失败");
            throw new RuntimeException(e);

        }


        System.out.println(list);
//            list.forEach(System.out::println);

        //转换为Csv
        if(CollUtil.isEmpty(list)){
            return  "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        //读取表头
        LinkedHashMap<Integer,String> headMap = (LinkedHashMap<Integer, String>) list.get(0);
        List<String> headerList = headMap.values().stream().filter(ObjectUtils::isNotEmpty).collect(Collectors.toList());
        stringBuilder.append(StringUtils.join(StringUtils.join(headerList,","))).append("\n");

        // 读取每一行数据
        for (int i=1;i< list.size();i++){
            LinkedHashMap<Integer, String> currentMap = (LinkedHashMap<Integer, String>) list.get(i);
            List<String> currentList = currentMap.values().stream().filter(ObjectUtils::isNotEmpty).collect(Collectors.toList());
            stringBuilder.append(StringUtils.join(currentList,",")).append("\n");
        }
        System.out.println(stringBuilder.toString());
        return  stringBuilder.toString();

//        return  "";

    }

    public static void main(String[] args) {
        excelToCsv(null);
    }
}

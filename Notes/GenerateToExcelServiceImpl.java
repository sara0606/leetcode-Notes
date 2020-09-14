package com.training.org.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.training.org.exception.OrgException;
import com.training.org.response.org.QueryOrgListResponse;
import com.training.org.service.GenerateToExcelService;
import com.training.service.common.constraint.SuccessResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @date 2020/6/5 10:18
 */
@Service
@Slf4j
public class GenerateToExcelServiceImpl implements GenerateToExcelService {

    @Override
    public  <T> String exportListToExcel(List<T> pList) {
        log.info("数据导出excel开始,待导出的数据：{}", JSONObject.toJSONString(pList));
        try (Workbook newWorkBook = new XSSFWorkbook()) {
            String theFileType = "xlsx";
            List<Map<String, ?>> dtModel = ToDataTable(pList);
            String[] _date = dateToArray();

            String relFilePath = "tempfile/" + (_date[0] + _date[1]) + "/";
            String theFileName =generateFileName(theFileType);

            File newFile = new File(Paths.get("tempfile/", _date[0] + _date[1], theFileName).toAbsolutePath().toString());
            if (!newFile.exists()) {
                newFile.createNewFile();
            }

            Sheet sheet = newWorkBook.createSheet("Sheet1");
            Map<String, ?> map = dtModel.get(0);
            setExcelValues(map,dtModel,sheet);

            //输出流
            FileOutputStream fileOutputStream = new FileOutputStream(newFile);
            //写入
            newWorkBook.write(fileOutputStream);
            log.info("导出excel完成，导出结果：{}",JSONObject.toJSONString(relFilePath+theFileName));
            return relFilePath+theFileName;
        } catch (Exception ex) {
            // 返回错误信息
            log.error("导出excel失败，原因：{}",ExceptionUtils.getStackTrace(ex));

            // 抛出异常
            throw OrgException.EXPORT_UN_KNOW_ERROR;
        }
    }



    private void setExcelValues(Map<String, ?> map, List<Map<String, ?>> dtModel, Sheet sheet ){

        Set<Integer> rows = new HashSet<>();
        int c = 0;
        for (String fieldName : map.keySet()) {
            for (int i = 0; i < dtModel.size() + 1; i++) {
                Map<String, ?> obj = dtModel.get(i == 0 ? 0 : i - 1);
                Row row;
                if (!rows.contains(i)) {
                    row = sheet.createRow(i);
                    rows.add(i);
                } else {
                    row = sheet.getRow(i);
                }
                if (i == 0) {
                    row.createCell(c).setCellValue(fieldName);
                } else {
                    row.createCell(c).setCellValue(Objects.toString(obj.get(fieldName), ""));
                }
            }
            c++;
        }
    }



    private String generateFileName(String theFileType){
        String epoch = String.valueOf(System.currentTimeMillis());
        Random rd = new Random();
        String theFileName = epoch + rd.nextInt(10001) + "." + theFileType;
        return theFileName;
    }


    private  String[] dateToArray(){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = simpleDateFormat.format(new Date());
        String[] _date = date.split("-");
        return _date;
    }


    //将list转换成DataTable
    private <T> List<Map<String, ?>> ToDataTable(List<T> list) {
        return list.stream()
                .map(this::fieldNameVals)
                .collect(Collectors.toList());

    }


    private Map<String, ?> fieldNameVals(Object obj) {
        return FieldUtils.getAllFieldsList(obj.getClass())
                .stream()
                .collect(Collectors.toMap(
                        Field::getName,
                        field ->
                        {
                            try {
                                return Optional.ofNullable(FieldUtils.readField(field, obj, true)).orElse("null");
                            } catch (IllegalAccessException e) {
                                log.error(ExceptionUtils.getStackTrace(e));
                                return "解析错误";
                            }
                        }));
    }


}

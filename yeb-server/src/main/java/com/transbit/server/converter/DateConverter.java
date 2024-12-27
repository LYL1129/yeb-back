package com.transbit.server.converter;
/**
 * @author lylstart
 * @data 2024/8/26 - 17:30
 * 2024 - 8月 - 周一 - 17 - 30
 */

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @description: 日期转换
 * @author jd
 * @date 2024/8/26 17:30
 * @version 1.0
 */
@Component
public class DateConverter implements Converter<String, LocalDate> {
    @Override
    public LocalDate convert(String s) {
        try {
            return LocalDate.parse(s, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

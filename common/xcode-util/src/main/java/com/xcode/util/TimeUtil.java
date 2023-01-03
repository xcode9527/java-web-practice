package com.xcode.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author zhoudawei
 * @Date 2023/1/3 16:08
 * @Version 1.0
 */
public class TimeUtil {

    private final static String FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND = "yyyy-MM-dd HH:mm:ss";
    private final static String FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE = "yyyy-MM-dd HH:mm";
    private final static String FORMAT_YEAR_MONTH_DAY_HOUR = "yyyy-MM-dd HH";
    private final static String FORMAT_YEAR_MONTH_DAY = "yyyy-MM-dd";
    private final static String FORMAT_HOUR_MINUTE_SECOND = "HH:mm:ss";

    /**
     * 字符串时间转LocalDate类型
     *
     * @param	time
     * @return  java.time.LocalDate
     */
    public static LocalDate stringToLocalDate(String time) {
        return LocalDate.parse(time, DateTimeFormatter.ofPattern(FORMAT_YEAR_MONTH_DAY));
    }

    /**
     * LocalDate格式化字符串
     *
     * @param	localDate
     * @param	format
     * @return  java.lang.String
     */
    public static String localDateToString(LocalDate localDate,String format) {
        return localDate.format(DateTimeFormatter.ofPattern(format));
    }

    /**
     * 字符串时间转LocalDateTime类型
     *
     * @param	time
     * @return  java.time.LocalDateTime
     */
    public static LocalDateTime stringToLocalDateTime(String time) {
        return LocalDateTime.parse(time, DateTimeFormatter.ofPattern(FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND));
    }

    /**
     * LocalDateTime格式化字符串
     *
     * @param	localDateTime
     * @param	format
     * @return  java.lang.String
     */
    public static String localDateTimeToString(LocalDateTime localDateTime,String format) {
        return localDateTime.format(DateTimeFormatter.ofPattern(format));
    }

}

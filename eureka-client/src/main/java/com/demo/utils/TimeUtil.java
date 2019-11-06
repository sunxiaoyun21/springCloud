package com.demo.utils;

import java.time.*;
import java.util.Date;

/**
 * @author 孙小云
 * @version 1.0
 * @date 2019/11/6 10:54
 **/
public class TimeUtil {


    public static long getTimestampOfDateTime(LocalDateTime localDateTime) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        return instant.toEpochMilli();
    }


    public static LocalDateTime getDateTimeOfTimestamp(long timestamp) {
        Instant instant = Instant.ofEpochMilli(timestamp);
        ZoneId zone = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zone);

    }

    public static Date getDateTime(LocalDateTime localDateTime){
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        return Date.from(zdt.toInstant());
    }

    /**
     * 两个时间的小时差
     * @return
     */
    public static long getHourDifference(LocalDateTime d1,LocalDateTime d2){
        Duration duration = Duration.between(d1,d2);
        return duration.toHours();

    }

    /**
     * 两个时间的天数差
     * @return
     */
    public static int getDayDifference(LocalDateTime d1,LocalDateTime d2){
        LocalDate  dayOne = d1.toLocalDate();
        LocalDate dayTwo = d2.toLocalDate();
        Period per = Period.between(dayOne, dayTwo);
        return per.getDays();

    }

    /**
     * 两个时间的月数差
     * @return
     */
    public static int getMonthDifference(LocalDateTime d1,LocalDateTime d2){
        LocalDate  dayOne = d1.toLocalDate();
        LocalDate dayTwo = d2.toLocalDate();
        Period per = Period.between(dayOne, dayTwo);
        return per.getMonths();

    }
}

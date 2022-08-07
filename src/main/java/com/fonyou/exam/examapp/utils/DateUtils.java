package com.fonyou.exam.examapp.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtils {
    public final String BogotaZoneId="America/Bogota";

    public static Date getDate(Date bogotaDate, String timeZoneId){
        LocalDateTime ldt = LocalDateTime.parse(bogotaDate.toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S"));
        //LocalDateTime ldt = LocalDateTime.parse(bogotaDate.toString(),ldt);
        ZoneId zone=ZoneId.of(timeZoneId);
        ZonedDateTime zonedDateTime=ldt.atZone(zone);
        return Date.from(Instant.from(zonedDateTime));
    }


}

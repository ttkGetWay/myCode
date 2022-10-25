package com.tking.andonsystem.util;


import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTool {
    public static Date now;
    public static Date date;
    public static Timestamp nowDate;

    public static Timestamp dateNow() {

        Timestamp timeStamp = new Timestamp((System.currentTimeMillis()));

        return timeStamp;
    }



}

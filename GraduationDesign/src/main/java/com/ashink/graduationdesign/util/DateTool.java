package com.ashink.graduationdesign.util;


import java.sql.Timestamp;
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

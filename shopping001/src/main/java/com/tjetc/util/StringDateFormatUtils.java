package com.tjetc.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringDateFormatUtils {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd") ;
    private static SimpleDateFormat simpleDateFormatTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss") ;
    /**
     * 字符串转为日期
     * @param strDate
     * @return
     */
    public static Date stringToDate(String strDate) {
        Date date = null;
        try {
            date = simpleDateFormat.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date ;
    }

    /**
     * 字符串转化为日期时间
     * @param strDate
     * @return
     */
    public static Date stringToDateTime(String strDate) {
        Date date = null;
        try {
            date = simpleDateFormatTime.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date ;
    }


    /**
     * 日期转换为字符串
     * @param date
     * @return
     */
    public static String dateToString(Date date) {
        return simpleDateFormat.format(date) ;
    }

    /**
     * 日期转换为字符串
     * @param date
     * @return
     */
    public static String dateTimeToString(Date date) {
        return simpleDateFormatTime.format(date) ;
    }

}

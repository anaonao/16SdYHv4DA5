package com.tjetc.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringDateFormatUtils {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd") ;

    /**
     * 字符串转为日期
     * @param strDate
     * @return
     */
    public static Date string2Date(String strDate) {
        Date date = null;
        try {
            date = simpleDateFormat.parse(strDate);
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
    public static String date2String(Date date) {
        return simpleDateFormat.format(date) ;
    }

}

package com.tjetc.test;

import com.tjetc.util.StringDateFormatUtils;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
    @Test
    public void dateString(){
        SimpleDateFormat simpleDateFormatTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss") ;
        Date date = new Date();
        System.out.println(date);
        System.out.println(simpleDateFormatTime.format(date));
        System.out.println(StringDateFormatUtils.stringToDateTime(simpleDateFormatTime.format(date)));
    }
}

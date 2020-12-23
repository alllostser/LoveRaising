package com.loveraising.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    /**
     * 获取服务器当前时间yyyy-MM-dd hh:mm:ss.SSS
     * @return
     */
    public static String getDateTime(){
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        return dateFormat.format(date);
    }

    /**
     * 日期格式转字符串类型
     * @param date
     * @return
     */
    public static String dateToString(Date date){
        if (date==null){
            return "";
        }
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
        return dateFormat.format(date);
    }
}

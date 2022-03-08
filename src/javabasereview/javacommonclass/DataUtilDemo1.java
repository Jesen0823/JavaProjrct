package javabasereview.javacommonclass;

import javabasereview.ProUtil;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * 日期相关操作
 */
public class DataUtilDemo1 {
    public static void main(String[] args) {
        long curTime = System.currentTimeMillis();
        Date date1 = new Date(curTime);
        Date date2 = new Date();
        System.out.println("Date: " + date1 + "|" + date2);
        ProUtil.printLine();
        Calendar calendar = new GregorianCalendar();
        System.out.printf("Calendar: %s年%s月%s日-%s时%s分%s秒\n",
                calendar.get(Calendar.YEAR)
                , calendar.get(Calendar.MONTH) + 1
                , calendar.get(Calendar.DAY_OF_MONTH)
                , calendar.get(Calendar.HOUR_OF_DAY)
                , calendar.get(Calendar.MINUTE)
                , calendar.get(Calendar.SECOND));
        ProUtil.printLine();
        String time1 = DateFormat.getDateInstance().format(new Date());
        String time2 = DateFormat.getDateTimeInstance().format(new Date());
        String time3 = DateFormat.getDateInstance(DateFormat.YEAR_FIELD
                , new Locale("zh", "CN")).format(new Date());
        String time4 = DateFormat.getDateTimeInstance(DateFormat.YEAR_FIELD, DateFormat.ERA_FIELD
                , new Locale("zh", "CN")).format(new Date());
        System.out.println("DateFormat: " + time1 + " | " + time2 + " | " + time3 + " | " + time4);
        ProUtil.printLine();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        String time5 = sdf.format(System.currentTimeMillis());
        Date time6 = null;
        try {
            time6 = sdf.parse("2020-11-20 14:58:34.345");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String time7 = sdf2.format(new Date());
        System.out.println("SimpleDateFormat: " + time7 + " | " + time5 + " | " + time6);
    }
}

package com.replay.dragon.rest.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by RoyChan on 2018/10/25.
 */
public class DateUtil {

    /**
     * adds or subtracts the specified amount of time to the given calendar field
     * @param n
     * @return
     * @throws ParseException
     */
    public static String addOrSubDay(int n) throws ParseException {
        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyyMMdd");

        Calendar c = Calendar.getInstance();
        c.setTime(date);

        int hour = c.get(Calendar.HOUR_OF_DAY);
        //凌晨3点前都算今天
        if (hour < 3){
            c.add(Calendar.DATE, -1);
        }
        c.add(Calendar.DATE, n);

        return ft.format(c.getTime());
    }

    public static int getYMD(Date date, int field){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(field);
    }

    public static String getDailyString(){
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        String week = switchChineseWeek(c.get(Calendar.DAY_OF_WEEK));
        int year = getYMD(date, Calendar.YEAR);
        int month = getYMD(date, Calendar.MONTH) + 1;
        int day = getYMD(date, Calendar.DAY_OF_MONTH);
        String dailyString = String.format("%d年%d月%d日 %s", year, month, day, week);
        return dailyString;
    }

    public static int getWeekday(){
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.DAY_OF_WEEK);
    }

    public static String getDailyPathName(){
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int year = getYMD(date, Calendar.YEAR);
        int month = getYMD(date, Calendar.MONTH) + 1;
        int day = getYMD(date, Calendar.DAY_OF_MONTH);
        String dayS = day > 10 ? String.valueOf(day) : "0"+day;
        String dailyString = String.format("%d%d%s", year, month, dayS);
        return dailyString;
    }

    private static String switchChineseWeek(int week){
        switch (week){
            case Calendar.SUNDAY:
                return "星期日";
            case Calendar.MONDAY:
                return "星期一";
            case Calendar.TUESDAY:
                return "星期二";
            case Calendar.WEDNESDAY:
                return "星期三";
            case Calendar.THURSDAY:
                return "星期四";
            case Calendar.FRIDAY:
                return "星期五";
            case Calendar.SATURDAY:
                return "星期六";
            default:
                return null;
        }
    }

    public static void main(String[] args) throws ParseException {

        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        System.out.println(c.get(Calendar.HOUR));

        System.out.println(DateUtil.addOrSubDay(0));
    }

}

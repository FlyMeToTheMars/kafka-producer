package com.jimi.producer;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class AnalogData {
    public static String[] alarm_types={"geozone","other"};
    public static String[] stautsArr={"status","129","48","79","stayTimeOut","194","in","6","14","20","9",
            "3","ACC_OFF","4","45","25","76","135","19","sensitiveAreasFenceOut","separationAlarm","11",
            "10","195","15","out","90","60","17","50","44","16","41","32","128","1","sensitiveAreasFence",
            "overSpeed","24","22","stayTimeIn","78","77","offline","192","riskPointAlarm","2","stayAlert","5",
            "ACC_ON","61","12","23","18","37"};
    public static List<String> imeis= new ArrayList<>();
    public static List<String> userids= new ArrayList<>();
    public static Random random = new Random();
    static {
        //868120000000000
        while (true){
            int imei = random.nextInt(999999999);
            if(!imeis.contains(imei)){
                imeis.add(868120000000000L+imei+"");
                userids.add(random.nextInt(1160838)+"");
            }else {
                continue;
            }
            if(imeis.size()>=700000)
                break;
        }

    }

    //随机生成数据建立时间
    private String randomDate(String startDate, String endDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date start = simpleDateFormat.parse(startDate);
            Date end = simpleDateFormat.parse(endDate);

            if (start.getTime() > end.getTime()) return null;

            long resultTime = start.getTime() + (long) (Math.random() * (end.getTime() - start.getTime()));
            return resultTime + "";
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    //拼接告警数据
    private String produceAlarmData() {
        int index = random.nextInt(imeis.size());
        String imei = imeis.get(index);
        String user_id = userids.get(index);
        String alarm_type = alarm_types[random.nextInt(alarm_types.length)];
        String status = stautsArr[random.nextInt(stautsArr.length)];


        //格式化通话时间，使位数一致
        String durationString = new DecimalFormat("0000").format("");
        //通话建立时间:yyyy-MM-dd,月份：0~11，天：1~31
        String randomDate = randomDate("2019-01-01", "2019-05-15");
        String dateString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.parseLong(randomDate));

        //拼接log日志
        StringBuilder logBuilder = new StringBuilder();


        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return logBuilder.toString();
    }

    public static void main(String[] args) {
        int imei = random.nextInt(999999999);
        System.out.println(imei);
    }
}

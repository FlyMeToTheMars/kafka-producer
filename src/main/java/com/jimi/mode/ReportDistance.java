package com.jimi.mode;

public class ReportDistance {
    private String imei;
    private String calcTime;
    private String distance;
    private String createtime;
    private String starttime;
    private String endtime ;

    public ReportDistance(String imei, String calcTime, String distance, String createtime, String starttime, String endtime) {
        this.imei=imei;
        this.calcTime = calcTime;
        this.distance = distance;
        this.createtime = createtime;
        this.starttime = starttime;
        this.endtime = endtime;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getCalcTime() {
        return calcTime;
    }

    public void setCalcTime(String calcTime) {
        this.calcTime = calcTime;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }
}

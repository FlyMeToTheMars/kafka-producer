package com.jimi.mode;

public class ReportAlarm {
    private String imei;
    private String addr;
    private String alertType;
    private String gpsTime ;
    private String fenceId ;
    private String lat ;
    private String lng ;
    private String postTime;
    private String offlineTime ;
    private String type ;
    private String iccid ;
    private String imsi ;
    private String accStatus ;
    private String time ;

    public ReportAlarm(String imei, String addr, String alertType, String gpsTime, String fenceId, String lat, String lng, String postTime, String offlineTime, String type, String iccid, String imsi, String accStatus, String time) {
        this.imei=imei;
        this.addr = addr;
        this.alertType = alertType;
        this.gpsTime = gpsTime;
        this.fenceId = fenceId;
        this.lat = lat;
        this.lng = lng;
        this.postTime = postTime;
        this.offlineTime = offlineTime;
        this.type = type;
        this.iccid = iccid;
        this.imsi = imsi;
        this.accStatus = accStatus;
        this.time = time;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getAlertType() {
        return alertType;
    }

    public void setAlertType(String alertType) {
        this.alertType = alertType;
    }

    public String getGpsTime() {
        return gpsTime;
    }

    public void setGpsTime(String gpsTime) {
        this.gpsTime = gpsTime;
    }

    public String getFenceId() {
        return fenceId;
    }

    public void setFenceId(String fenceId) {
        this.fenceId = fenceId;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

    public String getOfflineTime() {
        return offlineTime;
    }

    public void setOfflineTime(String offlineTime) {
        this.offlineTime = offlineTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public String getAccStatus() {
        return accStatus;
    }

    public void setAccStatus(String accStatus) {
        this.accStatus = accStatus;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

package com.jimi.mode;

public class ReportTrack {
    private String imei;
    private String startTime;
    private String endTime ;
    private String startLng ;
    private String startLat;
    private String startAddr;
    private String endLng ;
    private String endLat ;
    private String endAddr ;
    private String distance ;
    private String runTimeSecond ;
    private String avgSpeed ;
    private String method ;
    private String queryPoiTime ;
    private String status ;
    private String createTime ;
    private String avgFuel ;
    private String fuel ;
    private String gpsSize ;
    private String userId ;
    private String lastlnd ;
    private String lastlat ;

    public ReportTrack(String imei, String startTime, String endTime, String startLng, String startLat, String startAddr, String endLng, String endLat, String endAddr, String distance, String runTimeSecond, String avgSpeed, String method, String queryPoiTime, String status, String createTime, String avgFuel, String fuel, String gpsSize, String userId, String lastlnd, String lastlat) {
        this.imei=imei;
        this.startTime = startTime;
        this.endTime = endTime;
        this.startLng = startLng;
        this.startLat = startLat;
        this.startAddr = startAddr;
        this.endLng = endLng;
        this.endLat = endLat;
        this.endAddr = endAddr;
        this.distance = distance;
        this.runTimeSecond = runTimeSecond;
        this.avgSpeed = avgSpeed;
        this.method = method;
        this.queryPoiTime = queryPoiTime;
        this.status = status;
        this.createTime = createTime;
        this.avgFuel = avgFuel;
        this.fuel = fuel;
        this.gpsSize = gpsSize;
        this.userId = userId;
        this.lastlnd = lastlnd;
        this.lastlat = lastlat;
    }

    public String getLastlnd() {
        return lastlnd;
    }

    public void setLastlnd(String lastlnd) {
        this.lastlnd = lastlnd;
    }

    public String getLastlat() {
        return lastlat;
    }

    public void setLastlat(String lastlat) {
        this.lastlat = lastlat;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStartLng() {
        return startLng;
    }

    public void setStartLng(String startLng) {
        this.startLng = startLng;
    }

    public String getStartLat() {
        return startLat;
    }

    public void setStartLat(String startLat) {
        this.startLat = startLat;
    }

    public String getStartAddr() {
        return startAddr;
    }

    public void setStartAddr(String startAddr) {
        this.startAddr = startAddr;
    }

    public String getEndLng() {
        return endLng;
    }

    public void setEndLng(String endLng) {
        this.endLng = endLng;
    }

    public String getEndLat() {
        return endLat;
    }

    public void setEndLat(String endLat) {
        this.endLat = endLat;
    }

    public String getEndAddr() {
        return endAddr;
    }

    public void setEndAddr(String endAddr) {
        this.endAddr = endAddr;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getRunTimeSecond() {
        return runTimeSecond;
    }

    public void setRunTimeSecond(String runTimeSecond) {
        this.runTimeSecond = runTimeSecond;
    }

    public String getAvgSpeed() {
        return avgSpeed;
    }

    public void setAvgSpeed(String avgSpeed) {
        this.avgSpeed = avgSpeed;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getQueryPoiTime() {
        return queryPoiTime;
    }

    public void setQueryPoiTime(String queryPoiTime) {
        this.queryPoiTime = queryPoiTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAvgFuel() {
        return avgFuel;
    }

    public void setAvgFuel(String avgFuel) {
        this.avgFuel = avgFuel;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getGpsSize() {
        return gpsSize;
    }

    public void setGpsSize(String gpsSize) {
        this.gpsSize = gpsSize;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
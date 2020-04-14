package com.jimi.mode;

public class ReportStop {
    private String imei;
    private String startTime;
    private String endTime;
    private String durSecond;
    private String lng ;
    private String lat ;
    private String addr ;
    private String acc ;
    private String method ;
    private String createTime;
    private String userId ;
    private String userParentId ;
    private String stayPointType;

    public ReportStop(String imei, String startTime, String endTime, String durSecond, String lng, String lat, String addr, String acc, String method, String createTime, String userId, String userParentId, String stayPointType) {
        this.imei=imei;
        this.startTime = startTime;
        this.endTime = endTime;
        this.durSecond = durSecond;
        this.lng = lng;
        this.lat = lat;
        this.addr = addr;
        this.acc = acc;
        this.method = method;
        this.createTime = createTime;
        this.userId = userId;
        this.userParentId = userParentId;
        this.stayPointType = stayPointType;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
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

    public String getDurSecond() {
        return durSecond;
    }

    public void setDurSecond(String durSecond) {
        this.durSecond = durSecond;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getAcc() {
        return acc;
    }

    public void setAcc(String acc) {
        this.acc = acc;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserParentId() {
        return userParentId;
    }

    public void setUserParentId(String userParentId) {
        this.userParentId = userParentId;
    }

    public String getStayPointType() {
        return stayPointType;
    }

    public void setStayPointType(String stayPointType) {
        this.stayPointType = stayPointType;
    }
}

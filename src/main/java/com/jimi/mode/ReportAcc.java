package com.jimi.mode;

public class ReportAcc{
    private String imei;
    private String acc;
    private String starttime ;
    private String endtime ;
    private String durSecond;
    private String userId ;
    private String lastGpsTime;
    private String src ;
    private String createTime;

    public ReportAcc(String imei, String acc, String starttime, String endtime, String durSecond, String userId, String lastGpsTime, String src, String createTime) {
        this.imei=imei;
        this.acc = acc;
        this.starttime = starttime;
        this.endtime = endtime;
        this.durSecond = durSecond;
        this.userId = userId;
        this.lastGpsTime = lastGpsTime;
        this.src = src;
        this.createTime = createTime;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getAcc() {
        return acc;
    }

    public void setAcc(String acc) {
        this.acc = acc;
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

    public String getDurSecond() {
        return durSecond;
    }

    public void setDurSecond(String durSecond) {
        this.durSecond = durSecond;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLastGpsTime() {
        return lastGpsTime;
    }

    public void setLastGpsTime(String lastGpsTime) {
        this.lastGpsTime = lastGpsTime;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}

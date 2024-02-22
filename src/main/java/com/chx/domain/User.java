package com.chx.domain;
import java.util.Date;
public class User {
    private String openId;
    private String nickname;

    private int record;

    private String province;

    private Date updateTime;

    private String avatarUrl;
    public Date getUpdateTime() {
        return updateTime;
    }

    public String getNickname() {
        return nickname;
    }

    public String getOpenid() {
        return openId;
    }

    public String getProvince() {
        return province;
    }

    public int getRecord() {
        return record;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setOpenid(String openId) {
        this.openId = openId;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setRecord(int record) {
        this.record = record;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}

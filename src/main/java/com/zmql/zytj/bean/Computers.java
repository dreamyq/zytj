package com.zmql.zytj.bean;

public class Computers {
    private int id;
    private String name;
    private String ip;
    private ReadRooms readroomid;
    private String remark;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public ReadRooms getReadroomid() {
        return readroomid;
    }

    public void setReadroomid(ReadRooms readroomid) {
        this.readroomid = readroomid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}

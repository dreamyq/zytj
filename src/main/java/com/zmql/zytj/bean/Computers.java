package com.zmql.zytj.comentity;

public class Computers {
    private int id;
    private String name;
    private String ip;
    private int readroomid;
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

    public int getReadroomid() {
        return readroomid;
    }

    public void setReadroomid(int readroomid) {
        this.readroomid = readroomid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Computers{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ip='" + ip + '\'' +
                ", readroomid=" + readroomid +
                ", remark='" + remark + '\'' +
                '}';
    }


}

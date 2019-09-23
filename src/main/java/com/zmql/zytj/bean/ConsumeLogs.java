package com.zmql.zytj.comentity;

import java.util.Date;

public class ConsumeLogs {
    private int id;
    private int CardNo;
    private int ReadRoomID;
    private Date InTime;
    private Date OutTime;
    private  String Status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCardNo() {
        return CardNo;
    }

    public void setCardNo(int cardNo) {
        CardNo = cardNo;
    }

    public int getReadRoomID() {
        return ReadRoomID;
    }

    public void setReadRoomID(int readRoomID) {
        ReadRoomID = readRoomID;
    }

    public Date getInTime() {
        return InTime;
    }

    public void setInTime(Date inTime) {
        InTime = inTime;
    }

    public Date getOutTime() {
        return OutTime;
    }

    public void setOutTime(Date outTime) {
        OutTime = outTime;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    @Override
    public String toString() {
        return "ConsumeLogs{" +
                "id=" + id +
                ", CardNo=" + CardNo +
                ", ReadRoomID=" + ReadRoomID +
                ", InTime=" + InTime +
                ", OutTime=" + OutTime +
                ", Status='" + Status + '\'' +
                '}';
    }
}

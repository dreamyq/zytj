package com.zmql.zytj.bean;

import java.util.Date;

public class ConsumeLogs {
    private int id;
    private int cardNo;
    private int readRoomID;
    private Date inTime;
    private Date outTime;
    private  String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCardNo() {
        return cardNo;
    }

    public void setCardNo(int cardNo) {
        this.cardNo = cardNo;
    }

    public int getReadRoomID() {
        return readRoomID;
    }

    public void setReadRoomID(int readRoomID) {
        this.readRoomID = readRoomID;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

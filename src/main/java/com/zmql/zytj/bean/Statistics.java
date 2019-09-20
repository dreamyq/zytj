package com.zmql.zytj.bean;

public class Statistics {
    private int id;
    private ReadRooms readRoomID;
    private String peopleNums;
    private String year;
    private String month;
    private String day;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ReadRooms getReadRoomID() {
        return readRoomID;
    }

    public void setReadRoomID(ReadRooms readRoomID) {
        this.readRoomID = readRoomID;
    }

    public String getPeopleNums() {
        return peopleNums;
    }

    public void setPeopleNums(String peopleNums) {
        this.peopleNums = peopleNums;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}

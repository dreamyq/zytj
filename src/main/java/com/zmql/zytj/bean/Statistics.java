package com.zmql.zytj.comentity;

public class Statistics {
    private int id;
    private int ReadRoomID;
    private String PeopleNums;
    private String Year;
    private String Month;
    private String day;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReadRoomID() {
        return ReadRoomID;
    }

    public void setReadRoomID(int readRoomID) {
        ReadRoomID = readRoomID;
    }

    public String getPeopleNums() {
        return PeopleNums;
    }

    public void setPeopleNums(String peopleNums) {
        PeopleNums = peopleNums;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getMonth() {
        return Month;
    }

    public void setMonth(String month) {
        Month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "id=" + id +
                ", ReadRoomID=" + ReadRoomID +
                ", PeopleNums='" + PeopleNums + '\'' +
                ", Year='" + Year + '\'' +
                ", Month='" + Month + '\'' +
                ", day='" + day + '\'' +
                '}';
    }
}

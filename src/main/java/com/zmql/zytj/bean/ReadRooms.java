package com.zmql.zytj.bean;

public class ReadRooms {
    private int id;
    private String name;
    private String Remark;

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

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    @Override
    public String toString() {
        return "ReadRooms{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Remark='" + Remark + '\'' +
                '}';
    }
}

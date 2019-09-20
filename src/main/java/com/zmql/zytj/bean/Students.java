package com.zmql.zytj.bean;

public class Students {
    private int id;
    private int CardNO;
    private String Name;
    private String Sex;
    private int MembershipID;
    private String Status;
    private String Remark;
    private int StuNo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCardNO() {
        return CardNO;
    }

    public void setCardNO(int cardNO) {
        CardNO = cardNO;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public int getMembershipID() {
        return MembershipID;
    }

    public void setMembershipID(int membershipID) {
        MembershipID = membershipID;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    public int getStuNo() {
        return StuNo;
    }

    public void setStuNo(int stuNo) {
        StuNo = stuNo;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", CardNO=" + CardNO +
                ", Name='" + Name + '\'' +
                ", Sex='" + Sex + '\'' +
                ", MembershipID=" + MembershipID +
                ", Status='" + Status + '\'' +
                ", Remark='" + Remark + '\'' +
                ", StuNo=" + StuNo +
                '}';
    }
}

package com.zmql.zytj.comentity;

public class Teachers {
    private int id;
    private int CardNo;
    private String Name;
    private String Sex;
    private String SectionID;
    private String Status;
    private String Remark;

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

    public String getSectionID() {
        return SectionID;
    }

    public void setSectionID(String sectionID) {
        SectionID = sectionID;
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

    @Override
    public String toString() {
        return "Teachers{" +
                "id=" + id +
                ", CardNo=" + CardNo +
                ", Name='" + Name + '\'' +
                ", Sex='" + Sex + '\'' +
                ", SectionID='" + SectionID + '\'' +
                ", Status='" + Status + '\'' +
                ", Remark='" + Remark + '\'' +
                '}';
    }
}

package com.zmql.zytj.bean;

public class StudentsPage extends  Students {
    private int page;
    private  int rows;

    public int getPage() {
        return (page-1)*rows;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }
}

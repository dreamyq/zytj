package com.zmql.zytj.comentity;

public class Memberships {
    private int id;
    private String Department;
    private String Specialty;
    private String Degree;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public String getSpecialty() {
        return Specialty;
    }

    public void setSpecialty(String specialty) {
        Specialty = specialty;
    }

    public String getDegree() {
        return Degree;
    }

    public void setDegree(String degree) {
        Degree = degree;
    }

    @Override
    public String toString() {
        return "Memberships{" +
                "id=" + id +
                ", Department='" + Department + '\'' +
                ", Specialty='" + Specialty + '\'' +
                ", Degree='" + Degree + '\'' +
                '}';
    }
}

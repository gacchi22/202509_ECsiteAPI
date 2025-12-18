package com.example.demo.Study_08;

public class Staff extends Person {
    private String staffId;

    public Staff(String name, int age, String staffId) {
        super(name, age);
        this.staffId = staffId;
    }

    public String getStaffId() {
        return staffId;
    }

    // public void setStaffId(String staffId) {
    // this.staffId = staffId;
    // }

    @Override
    public String getRole() {
        return "スタッフ";
    }

    @Override
    public void printInfo() {
        System.out.println("氏名: " + name + ", 年齢: " + age + ", 役割: " + getRole() + ", スタッフID: " + staffId);
    }
}

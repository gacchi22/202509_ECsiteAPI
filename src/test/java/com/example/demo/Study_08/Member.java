package com.example.demo.Study_08;

public class Member extends Person {
    private String memberId;

    public Member(String name, int age, String memberId) {
        super(name, age);
        this.memberId = memberId;
    }

    public String getMemberId() {
        return memberId;
    }

    // public void setMemberId(String memberId) {
    // this.memberId = memberId;
    // }

    @Override
    public String getRole() {
        return "会員";
    }

    @Override
    public void printInfo() {
        System.out.println("氏名: " + name + ", 年齢: " + age + ", 役割: " + getRole() + ", 会員ID: " + memberId);
    }
}

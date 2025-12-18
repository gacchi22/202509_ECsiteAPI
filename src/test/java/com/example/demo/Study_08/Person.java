package com.example.demo.Study_08;

public abstract class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // public void setName(String name) {
    // this.name = name;
    // }

    // public void setAge(int age) {
    // this.age = age;
    // }

    public void printInfo() {
        System.out.println("氏名: " + name + ", 年齢: " + age + ", 役割: " + getRole());
    }

    public abstract String getRole();
}

package com.example.demo.Study_05;

public class Car extends Vehicle {
    // 問題 2：オーバーライド（親クラスのメソッドを子クラスで上書き）

    // Car クラスを Vehicle から継承してください。
    // move() をオーバーライドし、 "車が走ります" と表示する
    @Override
    public void move() {
        System.out.println("車が走ります");
    }
}

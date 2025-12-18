package com.example.demo.Study_05;

public class Bicycle extends Vehicle {
    // 問題 2：オーバーライド（親クラスのメソッドを子クラスで上書き）

    // Bicycle クラスを Vehicle から継承してください。
    // move() をオーバーライドし、 "自転車が走ります" と表示する
    @Override
    public void move() {
        System.out.println("自転車が走ります");
    }
}

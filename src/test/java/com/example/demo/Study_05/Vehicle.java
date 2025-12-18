package com.example.demo.Study_05;

public class Vehicle {
    // 問題 2：オーバーライド（親クラスのメソッドを子クラスで上書き）

    // Vehicle クラスを作成してください。
    // public void move() メソッドを持ち、 "乗り物が移動します" と表示する
    public void move() {
        System.out.println("乗り物が移動します");
    }

    // Car クラスを Vehicle から継承してください。
    // move() をオーバーライドし、 "車が走ります" と表示する

    // Bicycle クラスを Vehicle から継承してください。
    // move() をオーバーライドし、 "自転車が走ります" と表示する

    // Main クラスで以下を行ってください：
    // Vehicle 型の変数に Car と Bicycle のインスタンスを代入し、move() を呼び出して表示結果を確認してください。
}

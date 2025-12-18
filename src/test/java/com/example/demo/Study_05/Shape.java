package com.example.demo.Study_05;

public abstract class Shape {
    // 問題 3：応用（オーバーロード＋オーバーライド両方）

    // Shape 抽象クラスを作成してください。
    // public abstract double area(); を定義
    public abstract double area();

    // Rectangle クラスを Shape から継承してください。
    // フィールド：width, height
    // コンストラクタを2種類用意してください（オーバーロード）
    // Rectangle(double width, double height)
    // Rectangle(double side)（正方形用、幅と高さを同じ値にする）
    // area() をオーバーライドして面積を返してください。

    // Main クラスで Rectangle の2種類のコンストラクタを使ってオブジェクトを作り、面積を表示してください。
}

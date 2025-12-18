package com.example.demo.Study_05;

public class Rectangle extends Shape {
    // 問題 3：応用（オーバーロード＋オーバーライド両方）

    // Rectangle クラスを Shape から継承してください。
    // フィールド：width, height
    // コンストラクタを2種類用意してください（オーバーロード）
    // Rectangle(double width, double height)
    // Rectangle(double side)（正方形用、幅と高さを同じ値にする）
    // area() をオーバーライドして面積を返してください。
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle(double side) {
        this.width = side;
        this.height = side;
    }

    @Override
    public double area() {
        return width * height;
    }
}

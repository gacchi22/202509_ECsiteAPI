package com.example.demo.Study_05;

public class Main {
    public static void main(String[] args) {
        // 問題 1：オーバーロード（同じクラス内で引数違い）
        // Main クラスを作成し、MathUtil の各 add メソッドを呼び出して結果を表示してください。
        MathUtil mu = new MathUtil();
        System.out.println("2つの整数を足した結果: " + mu.add(37, 89));
        System.out.println("2つの少数を足した結果: " + mu.add(5.2, 4.9));
        System.out.println("3つの整数を足した結果: " + mu.add(43, 38, 19));

        // 問題 2：オーバーライド（親クラスのメソッドを子クラスで上書き）
        // Vehicle 型の変数に Car と Bicycle のインスタンスを代入し、move() を呼び出して表示結果を確認してください。
        Vehicle car = new Car();
        Vehicle bicycle = new Bicycle();
        car.move();
        bicycle.move();

        // 問題 3：応用（オーバーロード＋オーバーライド両方）
        // Main クラスで Rectangle の2種類のコンストラクタを使ってオブジェクトを作り、面積を表示してください。
        Rectangle r = new Rectangle(3.5, 8.0);
        Rectangle s = new Rectangle(5.5);
        System.out.println("長方形の面積: " + r.area());
        System.out.println("正方形の面積: " + s.area());
    }
}

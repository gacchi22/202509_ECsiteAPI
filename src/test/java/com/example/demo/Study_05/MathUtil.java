package com.example.demo.Study_05;

// 問題 1：オーバーロード（同じクラス内で引数違い）

// MathUtil クラスを作成してください。
public class MathUtil {

    // 以下の add メソッドをオーバーロードしてください：
    // int add(int a, int b)：2つの整数を足して返す
    // double add(double a, double b)：2つの小数を足して返す
    // int add(int a, int b, int c)：3つの整数を足して返す
    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }
    // Main クラスを作成し、MathUtil の各 add メソッドを呼び出して結果を表示してください。
}

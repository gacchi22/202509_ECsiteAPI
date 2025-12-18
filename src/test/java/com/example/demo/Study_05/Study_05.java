package com.example.demo.Study_05;

// メソッド・オーバーロード・オーバーライド

public class Study_05 {

    // 1️⃣ メソッド（基本）

    // 役割
    // 処理のまとまりを表す
    // 同じ処理を繰り返し使えるようにする

    // 書き方（基本形）
    // 戻り値の型 メソッド名(引数リスト) {
    // 処理
    // return 戻り値; // 戻り値がある場合
    // }

    // 例
    // public class Calculator {
    // public int add(int a, int b) {
    // return a + b;
    // }
    // }

    // ポイント：
    // add メソッドは int 型の値を2つ受け取って和を返す

    // 2️⃣ メソッド・オーバーロード (Method Overloading)

    // 仕組み
    // 同じメソッド名で引数の型・数が違うメソッドを複数定義できる
    // コンパイル時に呼び出すメソッドが決まる（静的ディスパッチ）

    // 書き方
    // public class Calculator {
    // int版
    // public int add(int a, int b) {
    // return a + b;
    // }

    // double版（引数の型が違う）
    // public double add(double a, double b) {
    // return a + b;
    // }

    // 3つのintを足す版（引数の数が違う）
    // public int add(int a, int b, int c) {
    // return a + b + c;
    // }
    // }

    // 呼び出し例
    // Calculator calc = new Calculator();
    // System.out.println(calc.add(3, 4)); // int版が呼ばれる
    // System.out.println(calc.add(3.5, 4.5)); // double版が呼ばれる
    // System.out.println(calc.add(1, 2, 3)); // 3引数版が呼ばれる

    // オーバーロードのポイント
    // メソッド名は同じでもOK
    // 引数リスト（型・数）が違う必要あり
    // 戻り値の型だけ違う場合はNG（コンパイルエラー）

    // 3️⃣ メソッド・オーバーライド (Method Overriding)

    // 仕組み
    // 親クラスのメソッドを子クラスで再定義する
    // 実行時に呼ばれるメソッドが決まる（動的ディスパッチ）

    // 書き方
    // class Animal {
    // public void makeSound() {
    // System.out.println("動物の鳴き声");
    // }
    // }

    // class Dog extends Animal {
    // @Override
    // public void makeSound() {
    // System.out.println("ワン！");
    // }
    // }

    // class Cat extends Animal {
    // @Override
    // public void makeSound() {
    // System.out.println("ニャー！");
    // }
    // }

    // 呼び出し例
    // Animal dog = new Dog();
    // Animal cat = new Cat();
    // dog.makeSound(); // 「ワン！」が出る
    // cat.makeSound(); // 「ニャー！」が出る

    // オーバーライドのポイント
    // 親クラスと同じメソッド名・引数・戻り値型で再定義する
    // アクセス修飾子は親クラス以上に制限を厳しくできない（例：親が public なら子も public）

    // @Override アノテーションを付けるとミスを防げる

    // 4️⃣ オーバーロード vs オーバーライド の違い
    // 項目 オーバーロード オーバーライド
    // 対象 同じクラス内 親クラスのメソッド
    // 引数 型・数が違う 親と同じ
    // 戻り値 ほぼ自由だが型推論に注意 親と同じか共変戻り値
    // 実行タイミング コンパイル時に決定 実行時に決定
    // アノテーション 付けない @Override を付けるのが推奨

    // 5️⃣ イメージで覚えるとラク

    // オーバーロード → 「同じ名前で使いやすくする便利機能」
    // オーバーライド → 「親の動きを子で上書きしてカスタマイズ」
}

package com.example.demo.Study_04;

// 練習問題：自作例外＋throws
// 問題 1

// UnderAgeException という自作例外クラスを作成してください。

// Exception を継承すること
// コンストラクタでエラーメッセージを受け取り、親クラスに渡すこと

public class UnderAgeException extends Exception {
    public UnderAgeException(String message) {
        super(message);
    }

    // 問題 2

    // AgeChecker クラスに checkAge(int age) メソッドを作成してください。
    // 年齢が18歳未満なら UnderAgeException を throw すること
    // メソッドシグネチャに throws UnderAgeException を記述すること

    // 問題 3

    // Main クラスを作成し、checkAge() メソッドを呼び出してください。
    // checkAge() の呼び出しを try/catch で囲み、例外メッセージを表示すること
    // 年齢18歳以上なら「OK: 年齢〇歳」と表示すること

    // 条件まとめ

    // throws を使うこと
    // throw new UnderAgeException() を使うこと
    // main では try/catch すること

    // 💡ヒント：構成イメージ
    // Main.java
    // AgeChecker.java
    // UnderAgeException.java
}

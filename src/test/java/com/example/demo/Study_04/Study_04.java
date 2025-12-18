package com.example.demo.Study_04;

import java.io.IOException;

// try/catch、throwsと自作例外クラス
public class Study_04 {
    // try/catchの基本構造
    // try {
    // 例外が発生する可能性のある処理
    // } catch (例外クラス e) {
    // 例外発生時の処理
    // }

    // tryブロック ：例外が発生する可能性のあるコードを書く
    // catchブロック：特定の例外が発生した場合に行う処理を書く

    // 具体例
    public class TryCatchExample {
        public static void main(String[] args) {
            try {
                int[] numbers = { 1, 2, 3 };
                System.out.println(numbers[3]); // 存在しない要素にアクセス
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("配列の範囲外です！");
            }

            System.out.println("プログラム終了");

            // 実行結果

            // 配列の範囲外です！
            // プログラム終了

            // numbers[3] で例外が発生
            // catch に入ってエラーメッセージが出る
            // 例外をキャッチしたのでプログラムは正常に継続できる

            // 複数のcatchブロック
            try {
                int x = Integer.parseInt("abc"); // 文字列→数値変換
            } catch (NumberFormatException e1) {
                System.out.println("数字に変換できません！");
            } catch (Exception e) {
                System.out.println("その他の例外が発生しました");
            }

            // より具体的な例外から先に書く（NumberFormatException → Exception）
            // 上位の Exception を先に書くとコンパイルエラーになる

            // 例外オブジェクトの利用
            try {
                int result = 10 / 0;
            } catch (ArithmeticException e2) {
                System.out.println("例外メッセージ：" + e2.getMessage());
                e2.printStackTrace(); // スタックトレースを表示
            }

            // finallyブロック（後片付け用）
            try {
                System.out.println("tryブロック実行");
            } catch (Exception e3) {
                System.out.println("catchブロック実行");
            } finally {
                System.out.println("finallyブロック実行（必ず実行される）");
            }

            // ファイルを閉じる、DB接続を切断するなど、後処理に使う

            // ポイントまとめ
            // 部分 役割
            // try 例外が発生する可能性のある処理を囲む
            // catch 例外が発生したときの処理
            // finally 必ず実行したい後処理（省略可）
            // e.getMessage() 例外メッセージを取得
            // e.printStackTrace() 詳細なエラー情報を出力
        }
    }

    // throwsの基本

    // 仕組み
    // メソッドの中で例外が発生する可能性がある場合、その場で catch せず、呼び出し元に例外を投げることができる
    // メソッド宣言に throws 例外クラス を付ける

    public class throwsExample {
        // 例外を呼び出し元へ投げる
        public static void riskyMethod() throws IOException {
            throw new IOException("ファイル読み込みエラー");
        }

        public static void main(String[] args) {
            try {
                riskyMethod();
            } catch (IOException e) {
                System.out.println("例外をキャッチしました：" + e.getMessage());
            }
        }
    }

    // ポイント：
    // riskyMethod は IOException を投げると宣言
    // main 側で try/catch して処理

    // throw と throws の違い
    // キーワード 使い方 例
    // throw 実際に例外オブジェクトを投げる throw new IOException();
    // throws メソッド宣言で「この例外を投げる可能性がある」と示す public void m() throws IOException

    // 自作例外クラス（独自例外）

    // 作る理由
    // 標準の例外クラスでは意味が分かりにくいときに、ドメイン固有の例外名を使うことで、
    // コードの可読性・保守性が上がる

    // 手順
    // 1.Exception または RuntimeException を継承したクラスを作る
    // 2.コンストラクタでメッセージを受け取れるようにする

    // 例：自作例外クラス
    public static class MyCustomException extends Exception {
        public MyCustomException(String message) {
            super(message);
        }
    }

    // 例：自作例外クラスの使用例
    public class CustomExceptionExample {

        // 特定条件で自作例外を投げる
        public static void checkNumber(int number) throws MyCustomException {
            if (number < 0) {
                throw new MyCustomException("負の値は許可されていません: " + number);
            }
            System.out.println("OK: " + number);
        }

        public static void main(String[] args) {
            try {
                checkNumber(-5);
            } catch (Exception e) {
                System.out.println("例外をキャッチ: " + e.getMessage());
            }
        }
    }

    // 実行結果
    // 例外をキャッチ: 負の値は許可されていません: -5

    // checked例外とunchecked例外
    // Exception を継承すると「checked例外」→ throws が必要
    // RuntimeException を継承すると「unchecked例外」→ throws 不要

    // まとめ表
    // 使い方 意味
    // throw 例外を実際に発生させる
    // throws メソッドが例外を投げる可能性を宣言
    // 自作例外 標準例外では意味が分かりにくい場合に独自の例外名を使う
}
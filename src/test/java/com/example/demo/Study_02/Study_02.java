package com.example.demo.Study_02;

public interface Study_02 {

    // 抽象クラス abstract
    abstract class Product {
        private String name;
        private int price;

        public Product(String name, int price) {
            this.name = name;
            this.price = price;
        }

        // 共通の処理
        public void printBasicInfo() {
            System.out.println("商品名：" + name + ", 価格：" + price + "円");
        }

        // 抽象メソッド（実装は子クラス任せ）
        public abstract void printDetail();
    }

    class Book extends Product {
        private String author;

        public Book(String name, int price, String author) {
            super(name, price);
            this.author = author;
        }

        @Override
        public void printDetail() {
            printBasicInfo();
            System.out.println("著者：" + author);
        }
    }

    public class Main1 {
        public static void main(String[] args) {
            Product book = new Book("Java入門", 2500, "山田太郎");
            book.printDetail();
        }
    }

    // abstract class は「部分的に未完成」なクラス
    // インスタンス化できない（必ずサブクラスで実装する必要がある）
    // 「共通処理 + 差分だけサブクラスで実装」したいときに便利

    // ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆

    // インターフェース interface
    interface Deliverable {
        void deliver(); // 配送処理（実装は各クラスに任せる）
    }

    class Book2 implements Deliverable {
        private String title;

        public Book2(String title) {
            this.title = title;
        }

        @Override
        public void deliver() {
            System.out.println("本『" + title + "』を宅配便で発送しました。");
        }
    }

    class EBook implements Deliverable {
        private String title;

        public EBook(String title) {
            this.title = title;
        }

        @Override
        public void deliver() {
            System.out.println("電子書籍『" + title + "』をメールで送信しました。");
        }
    }

    public class Main2 {
        public static void main(String[] args) {
            Deliverable book = new Book2("Java入門");
            Deliverable ebook = new EBook("Spring入門");

            book.deliver();
            ebook.deliver();
        }
    }

}
// interfaceは「契約」
// すべてのメソッドは「実装必須」
// 多重継承が可能（クラスは1つしか継承できないが、インターフェースは複数実装可能）

// ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆
// 抽象クラスとインターフェースの違い
// 項目 抽象クラス インターフェース
// ----------------------------------------------------------------------
// 継承 1つしか継承できない 複数実装可能
// フィールド 持てる（状態を持つ） 原則持たない（Java8以降はdefault/staticメソッドOK）
// 目的 「共通部分を持ちながら、差分だけ 「この機能を持つなら必ず
// 子クラスに任せたい」 このメソッドを実装せよ」
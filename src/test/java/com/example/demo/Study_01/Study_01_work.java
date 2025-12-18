package com.example.demo.Study_01;

public class Study_01_work {

    // 演習問題
    // 問題1:クラス作成
    private class Book {
        private String title;
        private String author;
        private int price;

        public Book(String title, String author, int price) {
            this.title = title;
            this.author = author;
            this.price = price;
        }

        public void printInfo() {
            System.out.println("書名：" + title + ", 著者：" + author + ", 価格：" + price);
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }

    public class Main1 {
        public static void main(String[] args) {
            // Book b = new Book("攻殻機動隊", "士郎正宗", 2000);
            // b.printInfo();
        }
    }

    // 問題2:継承
    class EBook extends Book {
        private int fileSize;
        // private MB fileSize;

        public EBook(String title, String author, int price, int fileSize) {
            super(title, author, price);
            this.fileSize = fileSize;
        }

        @Override
        public void printInfo() {
            super.printInfo();
            System.out.println("ファイルサイズ：" + fileSize + "MB");
        }
    }

    public class Main2 {
        public static void main(String[] args) {
            // EBook e = new EBook("アップルシード", "士郎正宗", 1800, 25);
            // e.printInfo();
        }
    }

    // 問題3:アクセス修飾子
    class Book2 {
        private String title;
        private String author;
        private int price;

        public Book2(String title, String author, int price) {
            this.title = title;
            this.author = author;
            this.price = price;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            if (price > 0) {
                this.price = price;
            } else {
                System.out.println("価格は0より大きい値を設定してください。");
            }
        }

        public void printInfo() {
            System.out.println("タイトル：" + title + ",著者：" + author + ",価格" + price + "円");
        }
    }

    public class Main3 {
        public static void main(String[] args) {
            // Book book = new Book("Javaデザインパターン", "鈴木一郎", 3000);
            // book.printInfo();

            // setterを使って価格を変更
            // book.setPrice(3500);
            // System.out.println("変更後の価格：" + book.getPrice() + "円");

            // // 不正な値を設定してみる
            // book.setPrice(-100);
        }
    }

    // public void changePrice() {
    // int p = e.getPrice();
    // p += 100
    // e.setPrice(p);
    // }

}

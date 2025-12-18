// 復習

// Javaのクラス・継承・アクセス修飾子

package com.example.demo.Study_01;

public class Study_01 {

    // クラスの定義
    // （本来はstaticではないが、一ファイルにまとめるためそうしている）
    public static class Product {
        // フィールド（メンバ変数）
        private String name;
        private int price;

        // コンストラクタ
        public Product(String name, int price) {
            this.name = name;
            this.price = price;
        }

        // メソッド（振る舞い）
        public void printInfo() {
            System.out.println("商品名：" + name + ", 価格：" + price);
        }

        // Getter / Setter
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }

    // 継承 Inheritance

    class Product2 {
        private String name;
        private int price;

        public Product2(String name, int price) {
            this.name = name;
            this.price = price;
        }

        public void printInfo() {
            System.out.println("商品名：" + name + ", 価格：" + price);
        }
    }

    // 子クラス
    // （本来はstaticではないが、一ファイルにまとめるためそうしている）
    public static class Electric extends Product {
        private int warranty; // 保証年数

        public Electric(String name, int price, int warranty) {
            super(name, price); // 親クラスのインスタンス呼び出し
            this.warranty = warranty;
        }

        @Override
        public void printInfo() {
            super.printInfo();
            System.out.println("保証年数：" + warranty + "年");
        }
    }

    public class Main {
        public static void main(String[] args) {
            Electric e = new Electric("テレビ", 50000, 3);
            e.printInfo();
        }
    }

}
package com.example.demo.Study_02;

public class Study_02_work {

    // 問題１：抽象クラス

    // Animal 抽象クラスを作成
    // フィールド: name
    // メソッド: printName()（共通処理）, makeSound()（抽象メソッド）
    // （本来はstaticではないが、一ファイルにまとめるためそうしている）
    abstract static class Animal {
        private String name;

        public Animal(String name) {
            this.name = name;
        }

        public void printName() {
            System.out.println("名前：" + name);
        }

        public abstract void makeSound();
    }

    // 子クラス Dog と Cat を作成
    // Dog.makeSound() → 「ワン！」
    // Cat.makeSound() → 「ニャー！」
    // （本来はstaticではないが、一ファイルにまとめるためそうしている）
    public static class Dog extends Animal {
        // private String sound;

        public Dog(String name) {
            super(name);
        }
        // public Dog(String name, String sound) {
        // super(name);
        // this.sound = sound;
        // }

        @Override
        public void makeSound() {
            System.out.println("ワン！");
        }
        // @Override
        // public void makeSound(String name, String sound) {
        // printName();
        // System.out.println("鳴き声：" + sound);
        // }
    }

    // （本来はstaticではないが、一ファイルにまとめるためそうしている）
    public static class Cat extends Animal {
        // private String sound;

        public Cat(String name) {
            super(name);
        }
        // public Cat(String name, String sound) {
        // super(name);
        // this.sound = sound;
        // }

        @Override
        public void makeSound() {
            System.out.println("ニャー！");
        }
        // @Override
        // public void makeSound(String name, String sound) {
        // printName();
        // System.out.println("鳴き声：" + sound);
        // }
    }

    // Main で動物の名前と鳴き声を表示
    public class Main1 {
        public static void main(String[] args) {
            Animal dog = new Dog("ポチ");
            Animal cat = new Cat("ミケ");

            dog.printName();
            dog.makeSound();

            cat.printName();
            cat.makeSound();
        }
    }

    // 問題２：インターフェース

    // Playable インターフェースを作成（play() メソッドを持つ）
    interface Playable {
        void play();
    }

    // Guitar クラスと Piano クラスで実装
    // Guitar → 「ギターを弾く！」
    // Piano → 「ピアノを弾く！」
    // （本来はstaticではないが、一ファイルにまとめるためそうしている）
    public static class Guitar implements Playable {

        @Override
        public void play() {
            System.out.println("ギターを弾く！");
        }
    }

    // （本来はstaticではないが、一ファイルにまとめるためそうしている）
    public static class Piano implements Playable {

        @Override
        public void play() {
            System.out.println("ピアノを弾く！");
        }
    }

    // Main で実行
    public class Main2 {
        public static void main(String[] args) {
            Playable guitar = new Guitar();
            Playable piano = new Piano();

            guitar.play();
            piano.play();
        }
    }

    // 問題３：複合

    // Shape 抽象クラスを作成（フィールド: color, 抽象メソッド: draw()）
    // （本来はstaticではないが、一ファイルにまとめるためそうしている）
    abstract static class Shape {
        // （本来はprotectedではなくprivateだが、一ファイルにまとめるためそうしている）
        protected String color;

        public Shape(String color) {
            this.color = color;
        }

        public abstract void draw();
    }

    // Drawable インターフェースを作成（draw()）
    interface Drawable {
        void draw();
    }

    // Circle クラスは Shape を継承 & Drawable を実装
    // （本来はstaticではないが、一ファイルにまとめるためそうしている）
    public static class Circle extends Shape implements Drawable {
        private int diameter;

        public Circle(String color, int diameter) {
            super(color);
            this.diameter = diameter;
        }

        @Override
        public void draw() {
            System.out.println("色：" + color + ", 直径：" + diameter + "の円を描画します。");
        }
    }

    // Main で Circle の描画を実行
    public class Main3 {
        public static void main(String[] args) {
            Drawable circle1 = new Circle("赤", 5);
            // Shape circle = new Circle("赤",5);

            circle1.draw();
        }
    }

}
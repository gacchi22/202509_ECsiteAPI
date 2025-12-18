package com.example.demo.Study_08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Scanner;

public class Main {

    // 📝 総まとめ課題：図書館管理システム（Library Management）

    // 概要
    // 本(Book) と 会員(Member) を管理する簡易システムを作成してください。
    // 以下の要素を順に実装し、最終的にコンソールで CRUD 操作ができるようにします。

    // 🔹 問題1：クラス・継承・アクセス修飾子
    // Person 抽象クラスを作成
    // フィールド：String name, int age
    // メソッド：printInfo()（共通処理）、getRole()（抽象メソッド）

    // Member クラスを作成（Personを継承）
    // 追加フィールド：String memberId
    // getRole() を「会員」として実装

    // Staff クラスを作成（Personを継承）
    // 追加フィールド：String staffId
    // getRole() を「スタッフ」として実装

    private static List<Member> members = new ArrayList<>();
    private static List<Book> books = new ArrayList<>();

    public static void main(String[] args) {

        // 🔹 問題1：クラス・継承・アクセス修飾子
        // Person 抽象クラスを作成
        // フィールド：String name, int age
        // メソッド：printInfo()（共通処理）、getRole()（抽象メソッド）

        // Member クラスを作成（Personを継承）
        // 追加フィールド：String memberId
        // getRole() を「会員」として実装

        // Staff クラスを作成（Personを継承）
        // 追加フィールド：String staffId
        // getRole() を「スタッフ」として実装

        Member member01 = new Member("Jason", 25, "1001");
        Staff staff01 = new Staff("Marie", 24, "10001");
        System.out.println(member01.getName() + " の役割: " + member01.getRole());
        System.out.println(staff01.getName() + " の役割: " + staff01.getRole());
        member01.printInfo();
        staff01.printInfo();

        // 🔹 問題2：インターフェース・抽象クラス演習
        // Borrowable インターフェースを作成
        // メソッド：borrowItem()、returnItem()

        // Book クラスを作成し、Borrowable を実装
        // フィールド：int id, String title, String author, boolean isBorrowed
        // borrowItem()：借りた状態にする
        // returnItem()：返却状態にする

        Book b1 = new Book(101, "月は無慈悲な夜の女王", "ハインライン");
        System.out.println(b1);
        b1.borrowItem();
        System.out.println(b1);
        b1.returnItem();
        System.out.println(b1);

        // List<Book> books = new ArrayList<>();
        // books.add(new Book(101, "月は無慈悲な夜の女王", "忘れた"));
        // books.add(new Book(102, "攻殻機動隊", "士郎正宗"));
        // books.add(new Book(103, "アンドロイドは電気羊の夢を見るか？", "フィリップ・K・ディック"));
        // books.add(new Book(104, "ドラえもん", "藤子・F・不二雄"));

        // books.get(0).borrowItem();
        // books.get(0).returnItem();
        // books.get(1).borrowItem();
        // books.get(1).borrowItem();
        // books.get(1).returnItem();
        // books.get(2).returnItem();

        // 🔹 問題3：コレクション(List, Map, Set) 演習
        // List<Member> を使って会員を管理
        // List<Book> を使って本を管理
        // Map<Member, List<Book>> を使って「誰がどの本を借りているか」を管理
        // Set<String> を使って「既に使われている会員ID」を管理

        // LibraryManagerを用意
        LibraryManager manager = new LibraryManager();

        // 会員を追加
        Member m1 = new Member("Bob", 30, "1002");
        Member m2 = new Member("Jack", 27, "1003");
        try {
            manager.addMember(m1);
            manager.addMember(m2);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("例外をキャッチ: " + e.getMessage());
        }

        // 本を追加
        Book b2 = new Book(102, "攻殻機動隊", "士郎正宗");
        Book b3 = new Book(103, "アンドロイドは電気羊の夢を見るか？", "Philip K. Dick");
        manager.addBook(b1);
        manager.addBook(b2);
        manager.addBook(b3);

        // 一覧表示
        manager.listMembers();
        manager.listBooks();

        // 本を借りる
        manager.borrowBook(m1, b1);

        // 借りている本一覧
        manager.listBorrowedBooks(m1);

        // 本を返す
        manager.returnBook(m1, b1);
        manager.listBorrowedBooks(m1);

        // List<Member> members = new ArrayList<>();
        // members.add(member01);
        // members.add(new Member("Bob", 30, "1002"));
        // members.add(new Member("Jack", 27, "1003"));

        // Map<Member, List<Book>> MapBorrowed = new HashMap<>();

        // Set<String> IdExisted = new HashSet<>();

        // 🔹 問題4：例外処理 try/catch, throws、自作例外クラス
        // AgeUnder18Exception 自作例外クラスを作成
        // 新規会員登録時に年齢が18歳未満なら例外を投げる
        // throws を使って呼び出し元に伝え、mainメソッドで try/catch でハンドリングする

        // 🔹 問題5：メソッド・オーバーロード・オーバーライド演習
        // Member クラスにメソッドを追加
        // printInfo() をオーバーライドして、memberId も表示する
        // borrowBook(Book book) と borrowBook(Book book, int days)
        // をオーバーロードして、借りる日数を指定できるようにする

        // 🔹 問題6：簡単なコンソールアプリで CRUD 処理作成
        // メニューを表示し、会員や本を追加・一覧・更新・削除できるようにする
        // さらに「本を借りる」「返す」機能も追加
        // Scanner で入力を受け取り、処理を行う

        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("=== メニュー ===");
            System.out.println("1:会員追加 2:会員一覧 3:本追加 4:本一覧 5: 借りる 6:返す 7:終了");
            System.out.print("選択 > ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: // 会員追加
                    System.out.print("氏名: ");
                    String name = sc.nextLine();
                    System.out.print("年齢: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("会員ID: ");
                    String memberId = sc.nextLine();
                    try {
                        Member m = new Member(name, age, memberId);
                        manager.addMember(m);
                        System.out.println("会員登録しました");
                    } catch (AgeUnder18Exception e) {
                        // TODO: handle exception
                        System.out.println("登録エラー: " + e.getMessage());
                    }
                    break;

                case 2: // 会員一覧
                    members.forEach(Member::printInfo);
                    break;

                case 3: // 本追加
                    System.out.print("本ID: ");
                    int id = sc.nextInt();
                    System.out.print("タイトル: ");
                    String title = sc.nextLine();
                    System.out.print("著者: ");
                    String author = sc.nextLine();
                    books.add(new Book(id, title, author));
                    System.out.println("本を追加しました");
                    break;

                case 4: // 本一覧
                    books.forEach(System.out::println);
                    break;

                case 5: // 借りる
                    System.out.print("会員ID: ");
                    int memId = sc.nextInt();
                    Member member = findMember(memId);
                    if (member == null) {
                        System.out.println("会員が見つかりません");
                        break;
                    }

                    System.out.print("本ID: ");
                    int bookId = sc.nextInt();
                    sc.nextLine();
                    Book book = findBook(bookId);
                    if (book == null) {
                        System.out.println("本が見つかりません");
                        break;
                    }

                    System.out.print("借りる日数(未入力ならEnter): ");
                    String daysInput = sc.nextLine();
                    if (daysInput.isEmpty()) {
                        manager.borrowBook(member, book);
                    } else {
                        int days = Integer.parseInt(daysInput);
                        manager.borrowBook(member, book, days);
                    }
                    break;

                case 6: // 返却する（簡易実装）
                    System.out.println("※ここでは実際の管理は省略して返却メッセージのみ表示します");
                    System.out.print("会員ID: ");
                    int memIdReturn = sc.nextInt();
                    sc.nextLine();
                    Member memberReturn = findMember(memIdReturn);
                    System.out.print("本ID: ");
                    int bookIdReturn = sc.nextInt();
                    sc.nextLine();
                    Book bookReturn = findBook(bookIdReturn);
                    if (memberReturn != null && bookReturn != null) {
                        System.out.println(memberReturn.getName() + " さんが " + bookReturn.getTitle() + " を返却しました");
                    } else {
                        System.out.println("会員または本が見つかりません");
                    }
                    break;

                case 7:
                    running = false;
                    break;

                default:
                    System.out.println("正しい番号を入力してください");
            }

        }
        sc.close();

        // 🔹 チャレンジ課題（応用）
        // Comparator＋ラムダ式を使って
        // 本を「タイトル順」「著者順」「ID順」にソートして表示する機能

        // 例外処理を追加し、不正な入力や存在しないIDに対する操作を丁寧にハンドリング
        // Member と Book に価格や出版日を追加して、複雑なデータを扱ってみる

        // 📝 提出形式
        // Main.java
        // Person.java
        // Member.java
        // Staff.java
        // Borrowable.java
        // Book.java
        // AgeUnder18Exception.java

        // （クラスはファイルごとに分割すること）

        // 📝 目標
        // この課題を通じて以下をマスターできます：
        // クラス、継承、アクセス修飾子の基本
        // 抽象クラスとインターフェースの使い分け
        // List / Map / Set の活用
        // 自作例外＋throws＋try/catch
        // メソッドのオーバーロード／オーバーライド
        // コンソールアプリで CRUD を作る流れ
        // Comparator＋ラムダ式での並べ替え

    }

    private static Member findMember(int memberId) {
        for (Member m : members) {
            if (Integer.parseInt(m.getMemberId()) == memberId) {
                return m;
            }
        }
        return null;
    }

    private static Book findBook(int id) {
        for (Book b : books) {
            if (b.getId() == id) {
                return b;
            }
        }
        return null;
    }

}

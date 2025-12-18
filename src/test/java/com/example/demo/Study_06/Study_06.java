package com.example.demo.Study_06;

public class Study_06 {

    // 1️⃣ CRUD処理とは
    // 処理 意味 Javaでのイメージ
    // C(Create) データの作成・追加 list.add(new Item(...));
    // R(Read) データの読み取り・一覧表示 for(Item i : list){...}
    // U(Update) データの更新・編集 検索してフィールドを書き換え
    // D(Delete) データの削除 list.remove(index);

    // ポイント
    // データベースを使わずに、まずはメモリ上（List, Mapなど）でCRUDの流れを体験するのがおすすめです。
    // コンソールアプリでは Scanner でユーザー入力を受け取り、メニュー方式にすると使いやすいです。

    // 2️⃣ 簡単な例（イメージ）
    // データクラス
    // public class User {
    // private int id;
    // private String name;

    // public User(int id, String name) {
    // this.id = id;
    // this.name = name;
    // }
    // public int getId() { return id; }
    // public String getName() { return name; }
    // public void setName(String name) { this.name = name; }

    // @Override
    // public String toString() {
    // return "User{id=" + id + ", name='" + name + "'}";
    // }
    // }

    // CRUDの骨組み
    // import java.util.ArrayList;
    // import java.util.List;
    // import java.util.Scanner;

    // public class Main {
    // public static void main(String[] args) {
    // List<User> users = new ArrayList<>();
    // Scanner sc = new Scanner(System.in);

    // while (true) {
    // System.out.println("1:追加 2:一覧 3:更新 4:削除 0:終了");
    // int menu = sc.nextInt();
    // sc.nextLine(); // 改行消費

    // switch (menu) {
    // case 1: // 追加
    // System.out.print("ID: ");
    // int id = sc.nextInt();
    // sc.nextLine();
    // System.out.print("名前: ");
    // String name = sc.nextLine();
    // users.add(new User(id, name));
    // break;
    // case 2: // 一覧
    // for (User u : users) {
    // System.out.println(u);
    // }
    // break;
    // case 3: // 更新
    // System.out.print("更新するID: ");
    // int uid = sc.nextInt();
    // sc.nextLine();
    // for (User u : users) {
    // if (u.getId() == uid) {
    // System.out.print("新しい名前: ");
    // String newName = sc.nextLine();
    // u.setName(newName);
    // break;
    // }
    // }
    // break;
    // case 4: // 削除
    // System.out.print("削除するID: ");
    // int did = sc.nextInt();
    // sc.nextLine();
    // users.removeIf(u -> u.getId() == did);
    // break;
    // case 0:
    // System.out.println("終了します");
    // return;
    // }
    // }
    // }
    // }

    // 3️⃣ 練習問題
    // ✅ 問題1（基礎）：

    // 「Book」クラス（id, title）を作成し、
    // コンソールアプリで 追加・一覧表示 ができるようにする。

    // ✅ 問題2（応用）：

    // 「Book」クラスに price を追加し、
    // 更新（IDで探してタイトルや価格を書き換える）機能を実装する。

    // ✅ 問題3（発展）：

    // 「Book」の削除機能を追加し、
    // メニュー形式（追加・一覧・更新・削除・終了）で操作できるようにする。

    // ✅ 問題4（挑戦）：

    // 「Book」の一覧を、Map<Integer, Book> で管理し、
    // IDをキーにしてCRUD処理を行うよう改造する。

    // 4️⃣ 学びポイント
    // List → 複数のデータを順序付きで保持する
    // Map → IDなどのキーとオブジェクトを紐づけて管理する
    // Scanner → コンソールから入力を受け取る
    // メニュー方式 → 繰り返し処理＋switch文で実装しやすい
    // 更新や削除では「検索して該当データを特定」するのがポイント
}

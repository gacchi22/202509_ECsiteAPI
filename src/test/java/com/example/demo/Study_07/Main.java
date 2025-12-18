package com.example.demo.Study_07;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<Book> books = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1:追加, 2:一覧, 3:更新, 4:削除, 5:終了,");
            System.out.println("6:タイトル順に並べ替え, 7:価格順に並べ替え, 8:出版日順に並べ替え");
            int menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1: // 追加
                    System.out.print("ID: ");
                    int cid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("タイトル: ");
                    String title = sc.nextLine();
                    System.out.print("著者: ");
                    String author = sc.nextLine();
                    System.out.print("価格: ");
                    int price = sc.nextInt();
                    sc.nextLine();
                    System.out.print("出版日（yyyy-MM-dd）: ");
                    String dateStr = sc.nextLine();
                    LocalDate publishDay = LocalDate.parse(dateStr);
                    // int publishDay = sc.nextInt();
                    // sc.nextLine();
                    books.add(new Book(cid, title, author, price, publishDay));
                    System.out.println("追加しました！");
                    break;

                case 2: // 一覧
                    System.out.println("=== 登録済みの本一覧 ===");
                    for (Book b : books) {
                        System.out.println(b);
                    }
                    break;

                case 3: // 更新
                    System.out.print("  更新する本のIDを入力: ");
                    int uid = sc.nextInt();
                    sc.nextLine();
                    boolean foundUpdate = false;
                    for (Book b : books) {
                        if (b.getId() == uid) {
                            System.out.print("新しいタイトル（空なら変更しない）: ");
                            String newTitle = sc.nextLine();
                            if (!newTitle.isEmpty()) {
                                b.setTitle(newTitle);
                            }
                            System.out.print("新しい著者（空なら変更しない）: ");
                            String newAuthor = sc.nextLine();
                            if (!newAuthor.isEmpty()) {
                                b.setAuthor(newAuthor);
                            }
                            System.out.print("新しい価格（空なら変更しない）: ");
                            int newPrice = sc.nextInt();
                            if (newPrice != 0) {
                                b.setPrice(newPrice);
                            }
                            System.out.print("新しい出版日（空なら変更しない）: ");
                            String newPublishDay = sc.nextLine();
                            if (!newPublishDay.isEmpty()) {
                                b.setPublishDay(LocalDate.parse(newPublishDay));
                            }
                            // b.setPublishDay(newPublishDay);
                            System.out.println("更新しました！");
                            foundUpdate = true;
                            break;
                        }
                    }

                    if (!foundUpdate) {
                        System.out.println("該当IDが見つかりません");
                    }
                    break;

                case 4: // 削除
                    System.out.print("ID: ");
                    int did = sc.nextInt();
                    boolean removed = books.removeIf(b -> b.getId() == did);
                    if (removed) {
                        System.out.println("削除しました！");
                    } else {
                        System.out.println("該当IDが見つかりません");
                    }
                    break;

                case 5: // 終了
                    return;

                case 6: // タイトル順に並べ替え
                    if (books.isEmpty()) {
                        System.out.println("登録されている本がありません");
                    } else {
                        books.sort((b1, b2) -> b1.getTitle().compareTo(b2.getTitle()));
                        // もしくは
                        // books.sort(Comparator.comparing(Books::getTitle));
                        System.out.println("=== タイトル順に並べ替えた一覧 ===");
                        for (Book b : books) {
                            System.out.println(b);
                        }
                        // もしくは
                        // books.forEach(System.out::println);
                    }
                    break;

                case 7: // 価格順に並べ替え
                    if (books.isEmpty()) {
                        System.out.println("登録されている本がありません");
                    } else {
                        books.sort(Comparator.comparing(Book::getPrice));
                        System.out.println("=== 価格順に並べ替えた本一覧 ===");
                        books.forEach(System.out::println);
                    }
                    break;

                case 8: // 出版日順に並べ替え
                    if (books.isEmpty()) {
                        System.out.println("登録されている本がありません");
                    } else {
                        books.sort(Comparator.comparing(Book::getPublishDay));
                        System.out.println("出版日順に並べ替えた本一覧");
                        books.forEach(System.out::println);
                    }
                    break;
                default:
                    System.out.println("1～8を入力してください");

            }
        }

    }
}

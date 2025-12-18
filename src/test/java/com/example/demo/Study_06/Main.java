package com.example.demo.Study_06;

import java.util.HashMap;
import java.util.Map;
// import java.util.ArrayList;
// import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Map<Integer, Book> books = new HashMap<>();
        // List<Book> books = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true)

        {
            System.out.println("1:追加 2:一覧 3:更新 4:削除 0:終了");
            int menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("タイトル: ");
                    String title = sc.nextLine();
                    System.out.print("価格: ");
                    int price = sc.nextInt();
                    sc.nextLine();
                    books.put(id, new Book(id, title, price));
                    // books.add(new Book(id, title, price));
                    break;

                case 2:
                    for (Book b : books.values()) {
                        // for (Book b : books) {
                        System.out.println(b);
                    }
                    break;

                case 3:
                    System.out.print("更新するID: ");
                    int bid = sc.nextInt();
                    sc.nextLine();
                    Book b = books.get(bid);
                    if (b != null) {
                        System.out.print("新しいタイトル: ");
                        String newTitle = sc.nextLine();
                        System.out.print("新しい価格: ");
                        int newPrice = sc.nextInt();
                        sc.nextLine();
                        b.setTitle(newTitle);
                        b.setPrice(newPrice);
                    } else {
                        System.out.println("そのIDは存在しません。");
                    }
                    // for (Book b : books) {
                    // if (b.getId() == bid) {
                    // System.out.print("新しいタイトル: ");
                    // String newTitle = sc.nextLine();
                    // System.out.print("新しい価格: ");
                    // int newPrice = sc.nextInt();
                    // sc.nextLine();
                    // b.setTitle(newTitle);
                    // b.setPrice(newPrice);
                    // break;
                    // }
                    // }
                    break;

                case 4:
                    System.out.print("削除するID: ");
                    int did = sc.nextInt();
                    sc.nextLine();
                    books.remove(did);
                    // books.removeIf(b -> b.getId() == did);
                    break;

                case 0:
                    return;
            }
        }
    }
}

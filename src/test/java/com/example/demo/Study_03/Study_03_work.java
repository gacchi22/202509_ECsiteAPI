package com.example.demo.Study_03;

import java.util.*;

public class Study_03_work {
    // ✅ 問題1: List の基本

    public class ListExample {
        public static void main(String[] args) {
            // List<String> を作成し、好きなフルーツを 5つ追加する。
            List<String> fruits = new ArrayList<>();
            fruits.add("Apple");
            fruits.add("Banana");
            fruits.add("Orange");
            fruits.add("Grape");
            fruits.add("Peach");

            // すべての要素を for-each で表示する。
            System.out.println("フルーツ一覧：");
            for (String string : fruits) {
                System.out.println(string);
            }

            // 3番目の要素を取得して表示する。
            System.out.println("3番目の要素：" + fruits.get(2));

            // "Apple" が含まれているかを調べる。
            System.out.println("Appleを含む？" + fruits.contains("Apple"));
        }
    }

    // ✅ 問題2: Set の基本

    public class SetExample {
        public static void main(String[] args) {
            // Set<Integer> を作成し、以下の値を追加する：
            // 10, 20, 30, 20, 10
            Set<Integer> numbers = new HashSet<>();
            numbers.add(10);
            numbers.add(20);
            numbers.add(30);
            numbers.add(20);
            numbers.add(10);

            // すべての要素を表示する。
            System.out.println("Setの内容：" + numbers);

            // 要素数を表示する。
            System.out.println(numbers.size());

            // 値 20 を削除し、削除後の内容を表示する。
            numbers.remove(20);
            System.out.println("20を削除後：" + numbers);
        }
    }

    // ✅ 問題3: Map の基本

    public class MapExample {
        public static void main(String[] args) {
            // Map<String, Integer> を作成し、以下のデータを追加する：
            // "Alice" → 23
            // "Bob" → 31
            // "Charlie" → 28
            Map<String, Integer> ages = new HashMap<>();
            ages.put("Alice", 23);
            ages.put("Bob", 31);
            ages.put("Charlie", 28);

            // すべてのキーと値を表示する。
            for (Map.Entry<String, Integer> entry : ages.entrySet()) {
                System.out.println(entry.getKey() + " → " + entry.getValue());
            }
            // "Bob" の年齢を取得して表示する。
            System.out.println("Bobの年齢：" + ages.get("Bob"));

            // "Alice" の年齢を 24 に更新して表示する。
            ages.put("Alice", 24);
            System.out.println("Aliceの年齢：" + ages.get("Alice"));

            // "David" が含まれているかを調べる。
            System.out.println("Davidを含む？" + ages.containsKey("David"));
        }
    }

}
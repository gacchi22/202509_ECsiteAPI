package com.example.demo.Study_03;
// 1.コレクションとは？

// 
// 種類     特徴
// ------------------------------------------------------
// List     順序あり、重複を許可
// Set      順序なし、重複を許可しない
// Map      キーと値のペアで管理。キーは重複不可

// 2.使い分けのイメージ
// List →順番に並んだもの（例：ショッピングカートの商品一覧）
// Set →重複を許さないもの（例：登録済みユーザーIDの一覧）
// Map →キーと値の対応が必要なもの（例：ユーザー名と年齢）

// コレクション(List, Map, Set) 演習

// 1.List
import java.util.*;

public class Study_03 {

    public class ListExample {
        public static void main(String[] args) {
            List<String> fruits = new ArrayList<>();
            fruits.add("apple");
            fruits.add("Banana");
            fruits.add("Orange");
            fruits.add("Apple"); // 重複OK

            // 順番に表示
            System.out.println("フルーツ一覧：");
            for (String fruit : fruits) {
                System.out.println(fruit);
            }

            // 特定の要素を取得
            System.out.println("2番目のフルーツ：" + fruits.get(1));

            // 要素が含まれているか
            System.out.println("Appleを含む？ " + fruits.contains("Apple"));
        }
    }

    // 2.Set
    // import java.util.*;

    public class SetExample {
        public static void main(String[] args) {
            Set<Integer> numbers = new HashSet<>();
            numbers.add(10);
            numbers.add(20);
            numbers.add(30);
            numbers.add(20); // 重複は無視される

            // 全要素を表示（順序は保証されない）
            System.out.println("Setの内容：" + numbers);

            // 要素数
            System.out.println("要素数：" + numbers.size());

            // 削除
            numbers.remove(20);
            System.out.println("20を削除後：" + numbers);

            // 含まれるか
            System.out.println("30を含む？" + numbers.contains(30));
        }
    }

    // 3.Map
    // import java.util.*;

    public class MapExample {
        public static void main(String[] args) {
            Map<String, Integer> ages = new HashMap<>();
            ages.put("Alice", 23);
            ages.put("Bob", 31);
            ages.put("Charlie", 28);

            // すべてのキーと値を表示
            for (Map.Entry<String, Integer> entry : ages.entrySet()) {
                System.out.println(entry.getKey() + " → " + entry.getValue());
            }

            // 特定のキーの値を取得
            System.out.println("Bobの年齢：" + ages.get("Bob"));

            // 値を更新
            ages.put("Alice", 24);
            System.out.println("Aliceの更新後：" + ages.get("Alice"));

            // キーが含まれるか
            System.out.println("Davidを含む？" + ages.containsKey("David"));
        }
    }

}
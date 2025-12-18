package com.example.demo.Study_06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Lambda {

    public static void main(String[] args) {

        // List<Integer> の中から偶数だけをフィルターして出力してください（ラムダ＋streamを使う）。

        List<Integer> numbers = new ArrayList<>();
        numbers.add(0);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(evenNumbers);

        // List<String> を長さ順にソートして出力してください（ラムダで Comparator を実装）。

        List<String> moji = Arrays.asList("こんにちは", "おはよう", "ありがとうございます");

        moji.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));

        System.out.println(moji);

        // Consumer<Integer> をラムダで定義して、受け取った数を2倍して表示する関数を作って呼び出してください。

        // Consumer<Integer>をラムダ式で定義
        Consumer<Integer> doubler = (n) -> {
            System.out.println("結果: " + (n * 2));
        };

        // 呼び出し（acceptメソッドを使う）
        doubler.accept(4);
        doubler.accept(10);
        doubler.accept(50);

    }

}

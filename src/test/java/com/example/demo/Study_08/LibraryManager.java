package com.example.demo.Study_08;

import java.util.*;

public class LibraryManager {

    // 会員リスト
    private List<Member> members = new ArrayList<>();
    // 本リスト
    private List<Book> books = new ArrayList<>();
    // だれがどの本を借りているか（Member -> List(Book)）
    private Map<Member, List<Book>> borrowMap = new HashMap<>();
    // 既に使われている会員ID（重複防止用）
    private Set<String> usedMemberIds = new HashSet<>();

    // 会員追加
    public void addMember(Member member) throws AgeUnder18Exception {
        if (usedMemberIds.contains(member.getMemberId())) {
            System.out.println("既に使用されている会員IDです: " + member.getMemberId());
            return;
        }

        if (member.getAge() < 18) {
            throw new AgeUnder18Exception("18歳未満の方は登録できません");
        }

        members.add(member);
        usedMemberIds.add(member.getMemberId());
        System.out.println("会員追加: " + member.getName());
    }

    // 本の追加
    public void addBook(Book book) {
        books.add(book);
        System.out.println("本追加: " + book.getTitle());
    }

    // 会員一覧表示
    public void listMembers() {
        System.out.println("=== 会員一覧 ===");
        for (Member m : members) {
            m.printInfo();
        }
    }

    // 本の一覧表示
    public void listBooks() {
        System.out.println("=== 本一覧 ===");
        for (Book b : books) {
            System.out.println(b);
        }
    }

    // 本を借りる
    public void borrowBook(Member member, Book book) {
        if (book.getIsBorrowed()) {
            System.out.println("この本はすでに借りられています: " + book.getTitle());
            return;
        }
        book.borrowItem();
        // 借りた本をMapに登録
        borrowMap.computeIfAbsent(member, k -> new ArrayList<>()).add(book);
        System.out.println(member.getName() + " さんが " + book.getTitle() + " を借りました");
    }

    public void borrowBook(Member member, Book book, int days) {
        if (book.getIsBorrowed()) {
            System.out.println("この本はすでに借りられています: " + book.getTitle());
            return;
        }
        book.borrowItem();
        // 借りた本をMapに登録
        borrowMap.computeIfAbsent(member, k -> new ArrayList<>()).add(book);
        System.out.println(member.getName() + " さんが " + book.getTitle() + " を借りました");
        System.out.println("貸出期間は " + days + " 日間です");
    }

    // 本を返却
    public void returnBook(Member member, Book book) {
        List<Book> borrowedBooks = borrowMap.get(member);
        if (borrowedBooks != null && borrowedBooks.contains(book)) {
            book.returnItem();
            borrowedBooks.remove(book);
            System.out.println(member.getName() + " さんが " + book.getTitle() + " を返却しました");

            // 借りた本がなくなったらMapからエントリを消す
            if (borrowedBooks.isEmpty()) {
                borrowMap.remove(member);
            }
        } else {
            System.out.println(member.getName() + " さんはその本を借りていません");
        }
    }

    // 借りている本を一覧表示
    public void listBorrowedBooks(Member member) {
        List<Book> borrowedBooks = borrowMap.get(member);
        System.out.println("=== " + member.getName() + " さんが借りている本 ===");
        if (borrowedBooks != null) {
            for (Book b : borrowedBooks) {
                System.out.println(b);
            }
        } else {
            System.out.println("借りている本はありません");
        }
    }
}

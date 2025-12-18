package com.example.demo.Study_08;

public class Book implements Borrowable {

    private int id;
    private String title;
    private String author;
    private boolean isBorrowed;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean getIsBorrowed() {
        return isBorrowed;
    }

    @Override
    public void borrowItem() {
        if (!isBorrowed) {
            isBorrowed = true;
            System.out.println(title + " を借りました。");
        } else {
            System.out.println(title + " はすでに借りられています。");
        }
        // isBorrowed = true;
    }

    public void returnItem() {
        if (isBorrowed) {
            isBorrowed = false;
            System.out.println(title + " を返却しました。");
        } else {
            System.out.println(title + " は借りられていません。");
        }
        // isBorrowed = false;
    }
}

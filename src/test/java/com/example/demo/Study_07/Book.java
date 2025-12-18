package com.example.demo.Study_07;

import java.time.LocalDate;

public class Book {

    private int id;
    private String title;
    private String author;
    private int price;
    private LocalDate publishDay;

    public Book(int id, String title, String author, int price, LocalDate publishDay) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.publishDay = publishDay;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPrice() {
        return price;
    }

    public LocalDate getPublishDay() {
        return publishDay;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setPublishDay(LocalDate publishDay) {
        this.publishDay = publishDay;
    }

    @Override
    public String toString() {
        return "Book{ID: " + id + ", タイトル: " + title + ", 著者: " + author + ", 価格: " + price + ", 出版日: " + publishDay
                + "}";
    }
}

package com.example.demo.Study_06;

public class Book {

    private int id;
    private String title;
    private int price;

    public Book(int id, String title, int price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{id=" + id + ", title='" + title + "', price=" + price + "円}";
    }
}

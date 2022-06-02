package com.example.demo.entity;

public class ProductEntity {
    public int id;
    public InputBook book;
    public int price;
    public int amount;
    public ProductEntity(int id, InputBook book, int price, int amount){
        this.id = id;
        this.book = book;
        this.price = price;
        this.amount = amount;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setBook(InputBook book) {
        this.book = book;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public InputBook getBook() {
        return book;
    }

    public int getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }
}

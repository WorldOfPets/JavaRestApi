package com.example.demo.entity;

public class BookEntity {
    public InputBook book;
    public int amount;
    public BookEntity(InputBook book, int amount){
        this.book = book;
        this.amount = amount;
    }

    public void setBook(InputBook book) {
        this.book = book;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public InputBook getBook() {
        return book;
    }

    public int getAmount() {
        return amount;
    }
}

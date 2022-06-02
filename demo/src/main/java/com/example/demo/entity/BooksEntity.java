package com.example.demo.entity;

import java.util.ArrayList;

public class BooksEntity {
    public ArrayList<BookEntity> books;
    public int balance;
    public BooksEntity(ArrayList<BookEntity>  books, int balance){
        this.books = books;
        this.balance = balance;
    }
    public void addBook(BookEntity book){
        this.books.add(book);
    }
    public void removeBook(BookEntity book){
        this.books.remove(book);
    }
    public void setBooks(ArrayList<BookEntity> books) {
        this.books = books;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public BookEntity getBook(int id)
    {
        return books.get(id);
    }

    public int getBalance() {
        return balance;
    }
}

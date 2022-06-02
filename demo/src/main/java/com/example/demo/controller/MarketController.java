package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.jsonParser.Parser;
import com.example.demo.testGenerator.testGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.ObjectReader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.logging.Logger;

@RestController
@RequestMapping("/market")
public class MarketController {

    public Logger logger = Logger.getLogger(MarketController.class.getName());
    ProductsEntity filterProducts;
    {
        try {
            filterProducts = new testGenerator().generateProducts().filterProductByAmount(0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    BooksController booksController = new BooksController();

    @GetMapping
    @RequestMapping(produces="application/json")
    public ResponseEntity getProducts(){
        try {
            filterProducts = new ProductsEntity(filterProducts.products).filterProductByAmount(0);
            String json = new ObjectMapper().writeValueAsString(filterProducts);

            return ResponseEntity.ok(json);
        } catch (Exception e){
            logger.warning(e.getMessage());
            return ResponseEntity.badRequest().body("Ошибка сервера: " + e.getMessage());
        }
    }

    @PostMapping("/deal")
    public ResponseEntity postProducts(@RequestBody PostBody postBody){
        try {
            ProductEntity product = filterProducts.getProductById(postBody.id);
            if(product != null){
                if(product.amount >= postBody.amount){
                    if((postBody.amount * product.price) <= booksController.books.balance){

                        booksController.books.balance -= postBody.amount * product.price;
                        booksController.books.getBook(postBody.id).amount -= postBody.amount;
                        product.amount -= postBody.amount;

                        return ResponseEntity.ok("Куплена книга!"
                                + "\nНазвание: " + product.book.name
                                + "\nАвтор: " + product.book.author
                                + "\nКоличество: " + postBody.amount
                                + "\nЦена: " + product.price * postBody.amount
                                + "\nБаланс: " + booksController.books.balance
                                + "\nОстаток книг: " + product.amount);
                    }
                    return ResponseEntity.badRequest().body("Недостаточно денег!");
                }
                else {
                    return ResponseEntity.badRequest().body("Недостаточно книг!");
                }
            }
            else {
                return ResponseEntity.badRequest().body("Такой книги не существует!");
            }
        } catch (Exception e){
            logger.warning(e.getMessage());
            return ResponseEntity.badRequest().body("Ошибка сервера: " + e.getMessage());
        }
    }
}

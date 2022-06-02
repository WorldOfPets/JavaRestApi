package com.example.demo.controller;

import com.example.demo.entity.BookEntity;
import com.example.demo.entity.BooksEntity;
import com.example.demo.testGenerator.testGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;


@RestController
@RequestMapping("/account")
public class BooksController {
    public Logger logger = Logger.getLogger(BooksController.class.getName());
    testGenerator generator = new testGenerator();
    public static BooksEntity books;
    {
        try {
            books = generator.generateBooks();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    @RequestMapping(produces="application/json")
    public ResponseEntity getBooks(){
        try {
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = ow.writeValueAsString(books);

            return ResponseEntity.ok(json);
        } catch (Exception e){
            logger.warning(e.getMessage());
            return ResponseEntity.badRequest().body("Ошибка сервера: " + e.getMessage());
        }
    }
}

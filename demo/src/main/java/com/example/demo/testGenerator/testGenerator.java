package com.example.demo.testGenerator;

import com.example.demo.entity.*;
import com.example.demo.jsonParser.BookParser;
import com.example.demo.jsonParser.Parser;
import org.springframework.expression.ExpressionException;


import java.util.ArrayList;
import java.util.logging.Logger;


public class testGenerator {
    public final Logger logger = Logger.getLogger(testGenerator.class.getName());
    public  ProductsEntity generateProducts() {
        try {
            ProductsEntity productsEntity = new ProductsEntity(new ArrayList<ProductEntity>());
            Parser data = new Parser();
            for (int i = 0; i < data.getData().books.length; i++){
                BookParser book = data.getData().books[i];
                productsEntity.addProduct(new ProductEntity(
                        i,
                        new InputBook(book.name, book.author),
                        book.price,
                        book.amount
                ));
            }
            return productsEntity;
        }
        catch (Exception ex){
            logger.warning(ex.getMessage());
            return null;
        }
    }
    public BooksEntity generateBooks(){
        try {
            Parser data = new Parser();
            BooksEntity booksEntity = new BooksEntity(new ArrayList<BookEntity>(), data.getData().account.money);
            for (int i = 0; i < data.getData().books.length; i++){
                BookParser book = data.getData().books[i];
                booksEntity.addBook(new BookEntity(new InputBook(book.name, book.author), book.amount));
            }
            return booksEntity;
        }
            catch (Exception ex){
            logger.warning(ex.getMessage());
            return null;
        }

    }
}

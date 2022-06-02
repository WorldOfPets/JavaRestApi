package com.example.demo.entity;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductsEntity {
    public ArrayList<ProductEntity> products;
    public ProductsEntity(ArrayList<ProductEntity> productEntities){
        this.products = productEntities;
    }
    public void addProduct(ProductEntity product){
        this.products.add(product);
    }
    public ProductsEntity filterProductByAmount(int amount){
        ProductsEntity pr = new ProductsEntity(products);
        pr.products.removeIf(x -> x.getAmount() <= amount);
        return pr;
    }
    public ProductEntity getProductById(int id){
        Optional<ProductEntity> optionalProductEntity = this.products.stream().filter(x -> x.id == id).findFirst();
        if (optionalProductEntity.isEmpty()){
            return null;
        }
        else {
            return optionalProductEntity.get();
        }
    }
}

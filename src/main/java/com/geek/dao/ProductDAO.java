package com.geek.dao;

import com.geek.model.Product;

import java.util.List;

public interface ProductDAO {
    Product getProductById(Long id);
    List<Product> getAllProducts();

    Product getProductByName(String name);

    void save(Product product);
    void updateProductNameById(Long id, String newName);
}

package com.example.auction.service;

import com.example.auction.model.Product;
import org.springframework.data.domain.Page;

public interface ProductService {
    Page<Product> getAllProducts(int page, int size);
    Product getProductById(Long id);
    Product saveProduct(Product product);
    void deleteProduct(Long id);
    Page<Product> searchProducts(String name, String category, int page, int size);
}

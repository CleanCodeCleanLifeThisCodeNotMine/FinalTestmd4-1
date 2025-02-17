package com.example.auction.service;

import com.example.auction.model.Product;
import com.example.auction.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Page<Product> getAllProducts(int page, int size) {
        return productRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Page<Product> searchProducts(String name, String category, int page, int size) {
        if (name != null && !name.isEmpty() && category != null && !category.isEmpty()) {
            return productRepository.findByNameContainingAndCategoryContaining(name, category, PageRequest.of(page, size));
        } else if (name != null && !name.isEmpty()) {
            return productRepository.findByNameContaining(name, PageRequest.of(page, size));
        } else if (category != null && !category.isEmpty()) {
            return productRepository.findByCategoryContaining(category, PageRequest.of(page, size));
        }
        return productRepository.findAll(PageRequest.of(page, size));
    }
}

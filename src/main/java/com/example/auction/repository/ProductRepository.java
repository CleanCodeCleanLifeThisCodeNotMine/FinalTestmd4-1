package com.example.auction.repository;

import com.example.auction.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findByNameContaining(String name, Pageable pageable);

    Page<Product> findByCategoryContaining(String category, Pageable pageable);

    Page<Product> findByNameContainingAndCategoryContaining(String name, String category, Pageable pageable);
}

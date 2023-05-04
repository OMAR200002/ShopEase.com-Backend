package com.example.ecommerce.repositories;

import com.example.ecommerce.entities.Category;
import com.example.ecommerce.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findProductsByCategory(Category category);
    Page<Product> findAll(Pageable pageable);
}

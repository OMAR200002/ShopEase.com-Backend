package com.example.ecommerce.repositories;

import com.example.ecommerce.entities.Customer;
import com.example.ecommerce.entities.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Long> {
    ShoppingCart findByCustomer(Customer customer);
}

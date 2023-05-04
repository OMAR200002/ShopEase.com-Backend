package com.example.ecommerce.repositories;

import com.example.ecommerce.entities.ShoppingCartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartItemRepository extends JpaRepository<ShoppingCartItem,Long> {
}

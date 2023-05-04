package com.example.ecommerce.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class ShoppingCartItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shoppingCartItemId;
    @ManyToOne
    private ShoppingCart shoppingCart;
    @ManyToOne
    private Product product;
    private int quantity;
}

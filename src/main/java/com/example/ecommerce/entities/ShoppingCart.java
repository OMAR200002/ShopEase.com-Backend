package com.example.ecommerce.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class ShoppingCart {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ShoppingCartId;
    @OneToMany(mappedBy = "shoppingCart")
    private List<ShoppingCartItem> shoppingCartItems;

    @OneToOne(mappedBy = "shoppingCart")
    private Customer customer;
}

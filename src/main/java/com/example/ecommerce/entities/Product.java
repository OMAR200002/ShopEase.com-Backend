package com.example.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private double price;
    private double discountPercentage;
    private double rating;

    private Long stock;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Category category;
    private String thumbnail;
    @OneToMany(mappedBy = "product")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<ProductImage> images = new ArrayList<>();
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<OrderItem> orderItemList;
    @OneToMany(mappedBy = "product")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<ShoppingCartItem> shoppingCartItemList;
}

package com.example.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Customer extends User{
    private String Address;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shoppingCart_id", referencedColumnName = "ShoppingCartId")
    private ShoppingCart shoppingCart;
    @OneToMany(mappedBy = "customer")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Order> orders;
}

package com.example.ecommerce.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data @NoArgsConstructor @AllArgsConstructor
public class Product1 {
    @JsonProperty(required = true)
    private Long id;
    @JsonProperty(required = true)
    private String title;
    @JsonProperty(required = true)
    private String description;
    @JsonProperty(required = true)
    private double price;
    @JsonProperty(required = true)
    private double discountPercentage;
    @JsonProperty(required = true)
    private double rating;
    @JsonProperty(required = true)
    private Long stock;
    @JsonProperty(required = true)
    private String category;
    @JsonProperty(required = true)
    private String thumbnail;
    @JsonProperty(required = true)
    private List<String> images;
}

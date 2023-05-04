package com.example.ecommerce;


import com.example.ecommerce.entities.Category;
import com.example.ecommerce.entities.Product;
import com.example.ecommerce.entities.ProductImage;
import com.example.ecommerce.models.Product1;
import com.example.ecommerce.repositories.CategoryRepository;
import com.example.ecommerce.repositories.ProductImageRepository;
import com.example.ecommerce.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class ECommerceApplication {
    private RestTemplate restTemplate;
    private HttpHeaders headers;

    public static void main(String[] args) {
        SpringApplication.run(ECommerceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CategoryRepository categoryRepository,
                            ProductRepository productRepository,
                            ProductImageRepository productImageRepository){
        return args -> {
            restTemplate = new RestTemplate();
            headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<Product1> request = new HttpEntity<>(headers);

            ResponseEntity<Product1[]> result = restTemplate.getForEntity("https://api.npoint.io/1dc9d4b1ca3a7c3d56a0", Product1[].class);
            Product1[] products = result.getBody();

            Arrays.stream(products).forEach(product -> {
                Product p = new Product();
                p.setTitle(product.getTitle());
                p.setDescription(product.getDescription());
                p.setPrice(product.getPrice());
                p.setDiscountPercentage(product.getDiscountPercentage());
                p.setRating(product.getRating());
                p.setStock(product.getStock());
                p.setThumbnail(product.getThumbnail());

                Category category = new Category();
                category.setTitle(product.getCategory());
                categoryRepository.save(category);
                p.setCategory(category);
                productRepository.save(p);

                product.getImages().forEach(image -> {
                    ProductImage productImage = new ProductImage();
                    productImage.setImagePath(image);
                    productImage.setProduct(p);
                    productImageRepository.save(productImage);
                });

            });

        };
    }
}

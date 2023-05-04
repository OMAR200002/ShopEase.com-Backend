package com.example.ecommerce.web;

import com.example.ecommerce.entities.Category;
import com.example.ecommerce.entities.Product;
import com.example.ecommerce.exceptions.CategoryNotFoundExcetion;
import com.example.ecommerce.service.EcommerceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class EcommerceRestController {
    private EcommerceService ecommerceService;
    @GetMapping("/products")
    public List<Product> productList(@RequestParam int page,@RequestParam int size){
        return ecommerceService.productsList(page, size);
    }
    @GetMapping("categories")
    public List<Category> categories() {
        return ecommerceService.categories();
    }
    @GetMapping("/categories/{title}")
    public List<Product> productsByCategory(@PathVariable String title) throws CategoryNotFoundExcetion {
        return ecommerceService.productsByCategory(title);
    }
}

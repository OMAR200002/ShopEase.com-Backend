package com.example.ecommerce.service;

import com.example.ecommerce.entities.*;
import com.example.ecommerce.exceptions.CategoryNotFoundExcetion;
import com.example.ecommerce.exceptions.CustomerNotFoundException;
import com.example.ecommerce.exceptions.ProductNotFoundException;
import org.hibernate.cache.spi.support.CacheUtils;

import java.util.List;

public interface EcommerceService {
    Customer customerById(Long customerId) throws CustomerNotFoundException;
    Customer saveCustomer(Customer customer);
    void deleteCustomer(Customer customer);


    List<Product> productsList(int page, int size);

    Product productById(Long productId) throws ProductNotFoundException;
    public List<Category> categories();
    List<Product> productsByCategory(String title) throws CategoryNotFoundExcetion;
    Product saveProduct(Product product);
    ShoppingCart createShoppingCart(Customer customer);

    ShoppingCart getShoppingCart(Customer customer);

    void saveShoppingCart(ShoppingCart shoppingCart);
    Order saveOrder(Order order,Customer customer);
    OrderItem saveOrderItem(OrderItem orderItem);
}

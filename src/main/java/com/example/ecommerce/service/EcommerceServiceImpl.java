package com.example.ecommerce.service;

import com.example.ecommerce.entities.*;
import com.example.ecommerce.exceptions.CategoryNotFoundExcetion;
import com.example.ecommerce.exceptions.CustomerNotFoundException;
import com.example.ecommerce.exceptions.ProductNotFoundException;
import com.example.ecommerce.repositories.*;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
@AllArgsConstructor
public class EcommerceServiceImpl implements EcommerceService {
    private UserRepository userRepository;
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private ShoppingCartRepository shoppingCartRepository;
    private OrderRepository orderRepository;
    private OrderItemRepository orderItemRepository;
    @Override
    public Customer customerById(Long customerId) throws CustomerNotFoundException {
        User user = userRepository.findById(customerId).orElseThrow(()-> new CustomerNotFoundException("Customer Not Found!"));
        if (user instanceof Customer){
            return (Customer) user;
        }
        else {
            throw new CustomerNotFoundException("Customer Not Found!");
        }
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return userRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Customer customer) {
        userRepository.delete(customer);
    }

    @Override
    public List<Product> productsList(int page, int size) {
        Page<Product> productsPage = productRepository.findAll(PageRequest.of(page,size));
        return productsPage.getContent();
    }

    @Override
    public Product productById(Long productId) throws ProductNotFoundException {
        return productRepository.findById(productId).orElseThrow(()->
                new ProductNotFoundException("Product Not Found Exception"));
    }

    @Override
    public List<Category> categories() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Product> productsByCategory(String title) throws CategoryNotFoundExcetion {
        Category category = categoryRepository.findCategoryByTitle(title);
        if (category == null) throw new CategoryNotFoundExcetion("Category not found exception");

        List<Product> productList = productRepository.findProductsByCategory(category);
        return productList;
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public ShoppingCart createShoppingCart(Customer customer) {
        ShoppingCart shoppingCart = new ShoppingCart();
        customer.setShoppingCart(shoppingCart);
        return shoppingCartRepository.save(shoppingCart);
    }
    @Override
    public ShoppingCart getShoppingCart(Customer customer){
        ShoppingCart shoppingCart = shoppingCartRepository.findByCustomer(customer);
        if (shoppingCart == null) {
            shoppingCart = createShoppingCart(customer);
        }
        return shoppingCart;
    }
    @Override
    public void saveShoppingCart(ShoppingCart shoppingCart) {
        shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public Order saveOrder(Order order,Customer customer) {
        order.setCustomer(customer);
       return orderRepository.save(order);
    }

    @Override
    public OrderItem saveOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }
}

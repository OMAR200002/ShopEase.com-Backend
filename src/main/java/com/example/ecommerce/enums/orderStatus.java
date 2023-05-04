package com.example.ecommerce.enums;

public enum orderStatus {
    /* The order has been received but has not yet been processed.*/
    Pending,
    /*The order has been successfully delivered to the customer.*/
    Delivered,
    /*The order has been cancelled, either by the customer or by the seller.*/
    Cancelled,
    /*The order has been refunded to the customer.*/
    Refunded
}

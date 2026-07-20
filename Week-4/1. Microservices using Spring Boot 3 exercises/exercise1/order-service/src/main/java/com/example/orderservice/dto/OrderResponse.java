package com.example.orderservice.dto;

import com.example.orderservice.model.Order;

public class OrderResponse {
    private Long id;
    private String product;
    private Double price;
    private UserDto user;

    public OrderResponse() {}

    public OrderResponse(Order order, UserDto user) {
        this.id = order.getId();
        this.product = order.getProduct();
        this.price = order.getPrice();
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }
}

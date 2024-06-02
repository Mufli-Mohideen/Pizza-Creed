package com.pizzacreed.pizzacreed_backend.service;

import com.pizzacreed.pizzacreed_backend.data_access_object.Order;
import com.pizzacreed.pizzacreed_backend.data_access_object.ShoppingBasket;
import com.pizzacreed.pizzacreed_backend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public class OrderServiceImpl implements OrderService{
    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    @Transactional
    public Order checkout(ShoppingBasket shoppingBasket) {
        // TODO: Implement this method
        return null;
    }
}

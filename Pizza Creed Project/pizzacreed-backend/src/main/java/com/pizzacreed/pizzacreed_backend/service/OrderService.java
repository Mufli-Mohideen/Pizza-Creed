package com.pizzacreed.pizzacreed_backend.service;

import com.pizzacreed.pizzacreed_backend.data_access_object.Order;
import com.pizzacreed.pizzacreed_backend.data_access_object.ShoppingBasket;

public interface OrderService {
    Order checkout(ShoppingBasket shoppingBasket);
}

package com.pizzacreed.pizzacreed_backend.service;

import com.pizzacreed.pizzacreed_backend.data_access_object.Order;
import com.pizzacreed.pizzacreed_backend.data_access_object.ShoppingBasket;

public interface ShoppingBasketService {
    ShoppingBasket createBasket();

    ShoppingBasket getBasketById(Long basketId);

    void addItemToBasket(Long basketId, Long pizzaId, int quantity);

    void removeItemFromBasket(Long basketId, Long itemId);

    void clearBasket(Long basketId);

    Order checkout(Long basketId);
}

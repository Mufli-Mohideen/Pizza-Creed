package com.pizzacreed.pizzacreed_backend.repository;

import com.pizzacreed.pizzacreed_backend.data_access_object.BasketItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketItemRepository extends JpaRepository<BasketItem, Long> {
    void deleteAllByShoppingBasketId(Long basketId);
}

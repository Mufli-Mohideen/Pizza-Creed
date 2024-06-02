package com.pizzacreed.pizzacreed_backend.repository;

import com.pizzacreed.pizzacreed_backend.data_access_object.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
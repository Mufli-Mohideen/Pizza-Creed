package com.pizzacreed.pizzacreed_backend.repository;

import com.pizzacreed.pizzacreed_backend.data_access_object.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Long> {

}

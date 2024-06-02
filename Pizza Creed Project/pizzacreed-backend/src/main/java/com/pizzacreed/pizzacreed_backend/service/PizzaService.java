package com.pizzacreed.pizzacreed_backend.service;

import com.pizzacreed.pizzacreed_backend.data_access_object.Pizza;

import java.util.List;

public interface PizzaService {
    List<Pizza> getAllPizzas();
    Pizza getPizzaById(Long pizzaId);
    Pizza savePizza(Pizza pizza); // Corrected return type
    void deletePizza(Long pizzaId);
    void editPizza(Long id, Pizza editedPizza);
    int getPizzaCount();
}

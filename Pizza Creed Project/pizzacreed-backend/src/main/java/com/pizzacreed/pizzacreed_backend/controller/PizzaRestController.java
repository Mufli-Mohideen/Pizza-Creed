package com.pizzacreed.pizzacreed_backend.controller;

import com.pizzacreed.pizzacreed_backend.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PizzaRestController {

    @Autowired
    private PizzaService pizzaService;

    @GetMapping("/pizzas")
    public Object getAllPizzas() {
        return pizzaService.getAllPizzas();
    }
}

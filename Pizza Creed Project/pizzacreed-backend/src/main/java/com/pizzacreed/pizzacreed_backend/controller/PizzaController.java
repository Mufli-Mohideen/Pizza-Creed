package com.pizzacreed.pizzacreed_backend.controller;

import com.pizzacreed.pizzacreed_backend.data_access_object.Pizza;
import com.pizzacreed.pizzacreed_backend.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
public class PizzaController {

    @Autowired
    private PizzaService pizzaService;

    @GetMapping("/")
    public String showHome(){
        return "redirect:/login";
    }

    @GetMapping("/dashboard")
    public String showDashboard(Model model){
        //add the count of pizzas to the model
        model.addAttribute("pizzaCount", pizzaService.getPizzaCount());

        return "dashboard";
    }

    @GetMapping("/menu")
    public String showMenu(Model model) {
        List<Pizza> pizzas = pizzaService.getAllPizzas();
        model.addAttribute("pizzas", pizzas);

        return "pizza";
    }

    @GetMapping("/addPizza")
    public String showAddPizzaForm(Model model) {
        model.addAttribute("newPizza", new Pizza()); // Create a new Pizza object to bind the form data
        return "addPizza";
    }

    @PostMapping("/addPizza")
    public String addPizza(Pizza newPizza, RedirectAttributes redirectAttributes) {
        pizzaService.savePizza(newPizza);
        redirectAttributes.addFlashAttribute("successMessage", "Pizza added successfully");
        return "redirect:/menu";
    }

    @GetMapping("/editPizza/{id}")
    public String showEditPizzaForm(@PathVariable Long id, Model model) {
        Pizza pizza = pizzaService.getPizzaById(id);
        model.addAttribute("pizza", pizza);
        return "editPizza";
    }

    @PostMapping("/editPizza/{id}")
    public String editPizza(@PathVariable Long id, Pizza editedPizza , RedirectAttributes redirectAttributes) {
        pizzaService.editPizza(id, editedPizza);
        redirectAttributes.addFlashAttribute("successMessage", "Pizza edited successfully");
        return "redirect:/menu";
    }

    @GetMapping("/deletePizza/{pizzaId}")
    public String deletePizza(@PathVariable Long pizzaId, RedirectAttributes redirectAttributes) {
        pizzaService.deletePizza(pizzaId);
        redirectAttributes.addFlashAttribute("successMessage", "Pizza deleted successfully");
        return "redirect:/menu";
    }
}


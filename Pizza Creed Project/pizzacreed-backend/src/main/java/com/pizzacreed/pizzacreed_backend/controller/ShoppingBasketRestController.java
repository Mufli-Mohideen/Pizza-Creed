package com.pizzacreed.pizzacreed_backend.controller;

import com.pizzacreed.pizzacreed_backend.data_access_object.BasketItem;
import com.pizzacreed.pizzacreed_backend.data_access_object.Order;
import com.pizzacreed.pizzacreed_backend.data_access_object.ShoppingBasket;
import com.pizzacreed.pizzacreed_backend.data_transfer_object.ShoppingBasketDTO;
import com.pizzacreed.pizzacreed_backend.exception.BasketAlreadyCheckedOutException;
import com.pizzacreed.pizzacreed_backend.service.ShoppingBasketService;
import com.pizzacreed.pizzacreed_backend.utilities.DTOConverter;
import com.pizzacreed.pizzacreed_backend.utilities.ExceptionHandlingService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
public class ShoppingBasketRestController {

    @Autowired
    private ShoppingBasketService shoppingBasketService;

    @PostMapping("/baskets")
    public ShoppingBasket createBasket() {
        return shoppingBasketService.createBasket();
    }

    @GetMapping("/baskets/{basketId}")
    public ResponseEntity<Object> getBasketById(@PathVariable Long basketId) {
        try {
            ShoppingBasket basket = shoppingBasketService.getBasketById(basketId);
            ShoppingBasketDTO basketDTO = DTOConverter.convertShoppingBasketToDTO(basket);
            return new ResponseEntity<>(basketDTO, HttpStatus.OK);
        } catch (EntityNotFoundException ex) {
            return ExceptionHandlingService.handleRestException(ex, HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            return ExceptionHandlingService.handleRestException(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/baskets/{basketId}")
    public ResponseEntity<Object> addProductToBasket(@PathVariable Long basketId, @RequestBody BasketItem basketItem) {
        try {
            shoppingBasketService.addItemToBasket(basketId, basketItem.getPizza().getId(), basketItem.getQuantity());
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Item added successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (EntityNotFoundException ex) {
            return ExceptionHandlingService.handleRestException(ex, HttpStatus.NOT_FOUND);
        } catch (BasketAlreadyCheckedOutException ex) {
            return ExceptionHandlingService.handleRestException(ex, HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            return ExceptionHandlingService.handleRestException(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/baskets/{basketId}/items/{itemId}")
    public ResponseEntity<Object> removeItemFromBasket(@PathVariable Long basketId, @PathVariable Long itemId) {
        try {
            shoppingBasketService.removeItemFromBasket(basketId, itemId);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Item removed successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (EntityNotFoundException ex) {
            return ExceptionHandlingService.handleRestException(ex, HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            return ExceptionHandlingService.handleRestException(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/baskets/{basketId}/items")
    public ResponseEntity<Object> clearItemsFromBasket(@PathVariable Long basketId) {
        try {
            shoppingBasketService.clearBasket(basketId);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Items cleared successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (EntityNotFoundException ex) {
            return ExceptionHandlingService.handleRestException(ex, HttpStatus.NOT_FOUND);
        } catch (BasketAlreadyCheckedOutException ex) {
            return ExceptionHandlingService.handleRestException(ex, HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            return ExceptionHandlingService.handleRestException(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/baskets/{basketId}/checkout")
    public ResponseEntity<Object> checkout(@PathVariable Long basketId) {

        try {
            Order order = shoppingBasketService.checkout(basketId);

            double totalAmount = order.getTotalAmount();

            // You can customize the response message and structure as needed
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Checkout successful");
            response.put("orderId", order.getId());
            response.put("totalAmount", totalAmount);

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (EntityNotFoundException ex) {
            return ExceptionHandlingService.handleRestException(ex, HttpStatus.NOT_FOUND);
        } catch (BasketAlreadyCheckedOutException ex) {
            return ExceptionHandlingService.handleRestException(ex, HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            return ExceptionHandlingService.handleRestException(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}

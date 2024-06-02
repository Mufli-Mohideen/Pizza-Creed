package com.pizzacreed.pizzacreed_backend.data_transfer_object;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShoppingBasketDTO {
    private Long id;
    private String status;
    private double totalAmount;
    private List<BasketItemDTO> items;
}

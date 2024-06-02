package com.pizzacreed.pizzacreed_backend.data_transfer_object;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BasketItemDTO {
    private Long id;
    private int quantity;
    private Long pizzaId;
    private String pizzaName;
    private String pizzaSize;
    private double pizzaPrice;
    private double total;
}

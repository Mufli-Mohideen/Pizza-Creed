package com.pizzacreed.pizzacreed_backend.data_access_object;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "pizza")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="size")
    private String size;

    @Column(name="price")
    private double price;
}

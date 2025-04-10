package com.inventory.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private String sku;
    private String category;
    private int quantity;
    private double price;
    private Long supplierId;
}
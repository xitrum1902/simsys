package com.simsys.warehouse.dto;

public class InventoryDTO {
    private Integer id;
    private String name;
    private String address;
    private Integer quantity;
    private String description;

    // Constructors
    public InventoryDTO() {
    }

    public InventoryDTO(Integer id, String name, String address, Integer quantity, String description) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.quantity = quantity;
        this.description = description;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

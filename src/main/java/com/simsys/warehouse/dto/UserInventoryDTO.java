package com.simsys.warehouse.dto;

public class UserInventoryDTO {
    private Integer id;
    private Boolean status;
    private Integer inventoryId;

    // Constructors
    public UserInventoryDTO() {
    }

    public UserInventoryDTO(Integer id, Boolean status, Integer inventoryId) {
        this.id = id;
        this.status = status;
        this.inventoryId = inventoryId;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }
}

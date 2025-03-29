package com.simsys.warehouse.dto;

import java.time.LocalDate;

public class ProductInventoryDTO {
    private Integer id;
    private Integer inventoryId;
    private LocalDate transferDate;

    // Constructors
    public ProductInventoryDTO() {
    }

    public ProductInventoryDTO(Integer id, Integer inventoryId, LocalDate transferDate) {
        this.id = id;
        this.inventoryId = inventoryId;
        this.transferDate = transferDate;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }

    public LocalDate getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(LocalDate transferDate) {
        this.transferDate = transferDate;
    }
}

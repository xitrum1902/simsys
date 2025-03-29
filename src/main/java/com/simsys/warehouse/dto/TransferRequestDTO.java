package com.simsys.warehouse.dto;

import java.time.LocalDate;

public class TransferRequestDTO {
    private Integer id;
    private String note;
    private Integer quantity;
    private LocalDate transferDate;
    private Integer toInventoryId;

    // Constructors
    public TransferRequestDTO() {
    }

    public TransferRequestDTO(Integer id, String note, Integer quantity, LocalDate transferDate, Integer toInventoryId) {
        this.id = id;
        this.note = note;
        this.quantity = quantity;
        this.transferDate = transferDate;
        this.toInventoryId = toInventoryId;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDate getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(LocalDate transferDate) {
        this.transferDate = transferDate;
    }

    public Integer getToInventoryId() {
        return toInventoryId;
    }

    public void setToInventoryId(Integer toInventoryId) {
        this.toInventoryId = toInventoryId;
    }
}

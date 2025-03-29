package com.simsys.warehouse.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransactionDTO {
    private Integer id;
    private BigDecimal money;
    private String note;
    private LocalDate date;
    private Integer userId; // Reference to UserEntity
    private Integer orderId; // Reference to OrderEntity

    // Constructors
    public TransactionDTO() {
    }

    public TransactionDTO(Integer id, BigDecimal money, String note, LocalDate date, Integer userId, Integer orderId) {
        this.id = id;
        this.money = money;
        this.note = note;
        this.date = date;
        this.userId = userId;
        this.orderId = orderId;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}

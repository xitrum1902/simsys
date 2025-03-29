package com.simsys.warehouse.dto;

public class CategoryDTO {
    private Integer id;
    private String name;
    private Integer productId;

    // Constructors
    public CategoryDTO() {
    }

    public CategoryDTO(Integer id, String name, Integer productId) {
        this.id = id;
        this.name = name;
        this.productId = productId;
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

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}

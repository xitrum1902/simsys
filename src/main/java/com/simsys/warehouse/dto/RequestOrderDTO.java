package com.simsys.warehouse.dto;

public class RequestOrderDTO {
    private Integer productDetailId;
    private Integer totalQuantity;
    private String productName;
    private String colorValues;
    private String sizeValues;

    public Integer getProductDetailId() {
        return productDetailId;
    }

    public void setProductDetailId(Integer productDetailId) {
        this.productDetailId = productDetailId;
    }

    public Integer getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Integer totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getColorValues() {
        return colorValues;
    }

    public void setColorValues(String colorValues) {
        this.colorValues = colorValues;
    }

    public String getSizeValues() {
        return sizeValues;
    }

    public void setSizeValues(String sizeValues) {
        this.sizeValues = sizeValues;
    }
}

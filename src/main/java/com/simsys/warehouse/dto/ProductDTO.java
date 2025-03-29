package com.simsys.warehouse.dto;

public class ProductDTO {
    private int productid;
    private String name;
    private int saleprice;
    private int quantity;
    private String description;
    private boolean status;
    private int consignmentid;

    public ProductDTO() {
    }

    public ProductDTO(int productid, String name, int saleprice, int quantity, String description, boolean status, int consignmentid) {
        this.productid = productid;
        this.name = name;
        this.saleprice = saleprice;
        this.quantity = quantity;
        this.description = description;
        this.status = status;
        this.consignmentid = consignmentid;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSaleprice() {
        return saleprice;
    }

    public void setSaleprice(int saleprice) {
        this.saleprice = saleprice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getConsignmentid() {
        return consignmentid;
    }

    public void setConsignmentid(int consignmentid) {
        this.consignmentid = consignmentid;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "productid=" + productid +
                ", name='" + name + '\'' +
                ", saleprice=" + saleprice +
                ", quantity=" + quantity +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", consignmentid=" + consignmentid +
                '}';
    }
}

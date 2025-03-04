package com.simsys.warehouse.projection;

public interface ProductDetailProjection {
    Integer getProductDetailId();

    Integer getTotalQuantity();

    String getProductName();

    String getColorValues();

    String getSizeValues();
}

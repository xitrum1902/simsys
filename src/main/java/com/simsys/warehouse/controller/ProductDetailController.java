package com.simsys.warehouse.controller;

import com.simsys.warehouse.projection.ProductDetailProjection;
import com.simsys.warehouse.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductDetailController {

    private final ProductDetailService productDetailService;

    @Autowired
    public ProductDetailController(ProductDetailService productDetailService) {
        this.productDetailService = productDetailService;
    }

    @GetMapping("/low-quantity")
    public List<ProductDetailProjection> getLowQuantityProducts(
            @RequestParam(defaultValue = "20") int limit) {
        return productDetailService.getProductDetailsWithVariants(limit);

    }

}

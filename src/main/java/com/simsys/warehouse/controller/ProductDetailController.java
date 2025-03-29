package com.simsys.warehouse.controller;

import com.simsys.warehouse.dto.ProductDetailDTO;
import com.simsys.warehouse.projection.ProductDetailProjection;
import com.simsys.warehouse.service.ProductDetailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products-detail")
@Tag(name = "Product Detail")
public class ProductDetailController {

    private final ProductDetailService productDetailService;

    public ProductDetailController(ProductDetailService productDetailService) {
        this.productDetailService = productDetailService;
    }

    @GetMapping("/low-quantity")
    private List<ProductDetailProjection> getLowQuantityProducts(
            @RequestParam(defaultValue = "20") int limit) {
        return productDetailService.getProductDetailsWithVariants(limit);

    }

    @Operation(summary = "Create Product Detail", description = "API to create a new Product Detail.")
    @ApiResponse(responseCode = "201", description = "Product Detail created successfully",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductDetailDTO.class)))
    @PostMapping
    public ResponseEntity<ProductDetailDTO> createProductDetail(@RequestBody ProductDetailDTO productDetailDTO) {
        ProductDetailDTO createdProductDetail = productDetailService.createProductDetail(productDetailDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProductDetail);
    }

    // READ ALL
    @Operation(summary = "Get All Product Details", description = "API to retrieve all Product Details.")
    @ApiResponse(responseCode = "200", description = "Product Details retrieved successfully",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductDetailDTO.class)))
    @GetMapping
    public ResponseEntity<List<ProductDetailDTO>> getAllProductDetails() {
        List<ProductDetailDTO> productDetails = productDetailService.getAllProductDetails();
        return ResponseEntity.ok(productDetails);
    }

    // READ BY ID
    @Operation(summary = "Get Product Detail by ID", description = "API to retrieve a Product Detail by its ID.")
    @ApiResponse(responseCode = "200", description = "Product Detail retrieved successfully",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductDetailDTO.class)))
    @ApiResponse(responseCode = "404", description = "Product Detail not found")
    @GetMapping("/{id}")
    public ResponseEntity<ProductDetailDTO> getProductDetailById(@PathVariable Integer id) {
        ProductDetailDTO productDetail = productDetailService.getProductDetailById(id);
        return ResponseEntity.ok(productDetail);
    }

    // UPDATE
    @Operation(summary = "Update Product Detail", description = "API to update an existing Product Detail.")
    @ApiResponse(responseCode = "200", description = "Product Detail updated successfully",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductDetailDTO.class)))
    @ApiResponse(responseCode = "404", description = "Product Detail not found")
    @PutMapping("/{id}")
    public ResponseEntity<ProductDetailDTO> updateProductDetail(@PathVariable Integer id, @RequestBody ProductDetailDTO productDetailDTO) {
        ProductDetailDTO updatedProductDetail = productDetailService.updateProductDetail(id, productDetailDTO);
        return ResponseEntity.ok(updatedProductDetail);
    }

    // DELETE
    @Operation(summary = "Delete Product Detail", description = "API to delete a Product Detail by its ID.")
    @ApiResponse(responseCode = "200", description = "Product Detail deleted successfully")
    @ApiResponse(responseCode = "404", description = "Product Detail not found")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductDetail(@PathVariable Integer id) {
        productDetailService.deleteProductDetail(id);
        return ResponseEntity.ok("Product Detail has been successfully deleted.");
    }

}

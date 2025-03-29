package com.simsys.warehouse.controller;

import com.simsys.warehouse.dto.ProductDTO;
import com.simsys.warehouse.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@Tag(name = "Product")
public class ProductController {


    final private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(summary = "Create Product", description = "API này tạo mới Product.")
    @ApiResponse(responseCode = "201", description = "Product has been successfully created.",
            content = @Content(mediaType = "application/json"))
    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody ProductDTO productDTO) {
        try {
            productService.createProduct(productDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("Product has been successfully created.");
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
    @Operation(summary = "Get All Products", description = "API này trả về danh sách tất cả Products.")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved.",
            content = @Content(mediaType = "application/json"))
    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        try {
            List<ProductDTO> products = productService.getAllProducts();
            return ResponseEntity.ok(products);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Operation(summary = "Get Product By ID", description = "API này trả về Product theo ID.")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved.",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "404", description = "Product not found.")
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable int id) {
        try {
            ProductDTO product = productService.getProductById(id);
            return ResponseEntity.ok(product);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @Operation(summary = "Update Product", description = "API này cập nhật Product theo ID.")
    @ApiResponse(responseCode = "200", description = "Product has been successfully updated.",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "404", description = "Product not found.")
    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestBody ProductDTO productDTO) {
        try {
            productService.updateProduct(id, productDTO);
            return ResponseEntity.ok("Product has been successfully updated.");
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @Operation(summary = "Delete Product", description = "API này xóa Product theo ID.")
    @ApiResponse(responseCode = "200", description = "Product has been successfully deleted.",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "404", description = "Product not found.")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        try {
            productService.deleteProduct(id);
            return ResponseEntity.ok("Product has been successfully deleted.");
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

}

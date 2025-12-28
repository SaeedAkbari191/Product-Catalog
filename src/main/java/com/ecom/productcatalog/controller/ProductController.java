package com.ecom.productcatalog.controller;


import com.ecom.productcatalog.dto.request.ProductRequest;
import com.ecom.productcatalog.dto.response.ProductResponse;
import com.ecom.productcatalog.model.Product;
import com.ecom.productcatalog.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/products")
@CrossOrigin("http://localhost:5173")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<ProductResponse>> getAllProductsByCategoryId(@PathVariable Long categoryId) {
        return ResponseEntity.ok(productService.findByCategoryId(categoryId));
    }

    @PostMapping("/category/{categoryId}")
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest productRequest, @PathVariable Long categoryId) {
        return ResponseEntity.ok(productService.createProduct(productRequest));
    }
}

package com.ecom.productcatalog.service;

import com.ecom.productcatalog.dto.request.ProductRequest;
import com.ecom.productcatalog.dto.response.ProductResponse;
import com.ecom.productcatalog.model.Product;

import java.util.List;

public interface ProductService {
    List<ProductResponse> getAllProducts();
    List<ProductResponse> findByCategoryId(Long categoryId);

    ProductResponse createProduct(ProductRequest productRequest);
}

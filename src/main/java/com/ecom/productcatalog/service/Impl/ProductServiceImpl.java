package com.ecom.productcatalog.service.Impl;

import com.ecom.productcatalog.dto.request.ProductRequest;
import com.ecom.productcatalog.dto.response.ProductResponse;
import com.ecom.productcatalog.model.Category;
import com.ecom.productcatalog.model.Product;
import com.ecom.productcatalog.repository.CategoryRepository;
import com.ecom.productcatalog.repository.ProductRepository;
import com.ecom.productcatalog.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(this::createProductResponse)
                .toList();
    }

    @Override
    public List<ProductResponse> findByCategoryId(Long categoryId) {
        return productRepository.findByCategoryId(categoryId)
                .stream()
                .map(this::createProductResponse)
                .toList();
    }

    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {
        Category category = categoryRepository.findById(productRequest.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category id " + productRequest.getCategoryId() + " not found")
        );
        Product product = changeToProduct(productRequest);
        product.setCategory(category);


        return createProductResponse(productRepository.save(product));
    }

    private Product changeToProduct(ProductRequest productRequest) {
        return Product.builder()
                .name(productRequest.getName())
                .price(productRequest.getPrice())
                .description(productRequest.getDescription())
                .imageUrl(productRequest.getImageUrl())
                .build();
    }

    private ProductResponse createProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .imageUrl(product.getImageUrl())
                .categoryId(product.getCategory().getId())
                .price(product.getPrice())
                .build();

    }
}

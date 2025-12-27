package com.ecom.productcatalog.dto.response;

import com.ecom.productcatalog.model.Category;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductResponse {
    private Long id;
    private String name;
    private String description;
    private String imageUrl;
    private Double price;
    private Long categoryId;
}

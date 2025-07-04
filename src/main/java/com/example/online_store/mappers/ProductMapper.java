package com.example.online_store.mappers;

import com.example.online_store.models.product.ProductEntity;
import com.example.online_store.models.product.ProductRequest;
import com.example.online_store.models.product.ProductResponse;

public class ProductMapper {

    public static ProductEntity mapRequestToEntity(ProductRequest productRequest) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(productRequest.getName());
        productEntity.setDescription(productRequest.getDescription());
        productEntity.setCount(productRequest.getCount());

        return productEntity;
    }

    public static ProductResponse mapEntityToResponse(ProductEntity productEntity) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(productEntity.getId());
        productResponse.setName(productEntity.getName());
        productResponse.setDescription(productEntity.getDescription());
        productResponse.setCount(productEntity.getCount());

        return productResponse;
    }
    
}

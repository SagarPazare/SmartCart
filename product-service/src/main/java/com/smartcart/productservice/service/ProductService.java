package com.smartcart.productservice.service;

import com.smartcart.productservice.dto.ProductRequest;
import com.smartcart.productservice.dto.ProductResponse;

import java.util.List;

public interface ProductService {

    ProductResponse createProduct(ProductRequest request);

    List<ProductResponse> getAllProducts();

    ProductResponse getProductById(Long id);

    ProductResponse updateProduct(Long id, ProductRequest request);

    void deleteProduct(Long id);

    List<ProductResponse> getProductsByCategory(String category);

    List<ProductResponse> searchProducts(String name);
}
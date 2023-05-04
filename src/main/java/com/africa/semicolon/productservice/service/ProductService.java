package com.africa.semicolon.productservice.service;

import com.africa.semicolon.productservice.dto.request.ProductRequest;
import com.africa.semicolon.productservice.dto.response.ProductResponse;
import com.africa.semicolon.productservice.models.Product;

import java.util.List;

public interface ProductService {
    ProductResponse addProduct(ProductRequest productRequest);
    Object removeProduct(String productId);
    ProductResponse editProduct(ProductRequest productRequest, String productId);
    List<Product> veiwAll();
    Product  viewById(String productId);

}

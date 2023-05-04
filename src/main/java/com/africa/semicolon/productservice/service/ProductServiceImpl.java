package com.africa.semicolon.productservice.service;

import com.africa.semicolon.productservice.dto.request.ProductRequest;
import com.africa.semicolon.productservice.dto.response.ProductResponse;
import com.africa.semicolon.productservice.exception.GenericException;
import com.africa.semicolon.productservice.models.Product;
import com.africa.semicolon.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Override
    public ProductResponse addProduct(ProductRequest productRequest) {
        Product product = new Product(
                productRequest.getName(),
                productRequest.getDescription(),
                productRequest.getPrice()
        );
        productRepository.save(product);

        return new ProductResponse(
                product.getName(),
                product.getDescription(),
                product.getPrice()
        );

    }

    @Override
    public String removeProduct(String productId) {
        var foundProduct = productRepository.findById(productId).orElseThrow(() -> new GenericException("product not found"));
        productRepository.delete(foundProduct);
        return "deleted";
    }

    @Override
    public ProductResponse editProduct(ProductRequest productRequest, String productId) {
        var foundProduct = productRepository.findById(productId).orElseThrow(()-> new GenericException("product not found"));
        foundProduct.setDescription(productRequest.getDescription());
        foundProduct.setName(productRequest.getName());
        foundProduct.setPrice(productRequest.getPrice());
        productRepository.save(foundProduct);

        return new ProductResponse(
                foundProduct.getName(),
                foundProduct.getDescription(),
                foundProduct.getPrice()
        );
    }

    @Override
    public List<Product> veiwAll() {
        return productRepository.findAll();
    }

    @Override
    public Product viewById(String productId) {
       return productRepository.findById(productId).orElseThrow(()-> new GenericException("product not found"));

    }
}

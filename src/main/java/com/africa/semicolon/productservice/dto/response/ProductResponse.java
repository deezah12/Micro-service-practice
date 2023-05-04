package com.africa.semicolon.productservice.dto.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductResponse {
    private String name;
    private String description;
    private BigDecimal price;

    public ProductResponse(String name, String description, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
}

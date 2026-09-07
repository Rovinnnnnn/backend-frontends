package com.rovinn.backendfrontends.model;

import lombok.Data;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private String category;
    private Double price;
}


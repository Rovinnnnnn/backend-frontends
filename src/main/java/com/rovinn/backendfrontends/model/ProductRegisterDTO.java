package com.rovinn.backendfrontends.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;


@Data
public class ProductRegisterDTO {
    @NotBlank (message = "Name is required")
    private String name;

    private String description;

    @NotBlank (message = "Category is required")
    private String category;

    @NotNull (message ="Price is required")
    @Positive (message = "Price must greater than 0")
    private Double price;
}

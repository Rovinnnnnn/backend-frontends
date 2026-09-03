package com.rovinn.backendfrontends.model;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserLoginDTO {
    @NotBlank (message = "email is required")
    private String email;
    @NotBlank (message = "Password is required")
    private String password;
}

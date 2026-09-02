package com.rovinn.backendfrontends.model;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserLoginDTO {
    @NotBlank (message = "Username is required")
    private String username;
    @NotBlank (message = "Password is required")
    private String password;
}

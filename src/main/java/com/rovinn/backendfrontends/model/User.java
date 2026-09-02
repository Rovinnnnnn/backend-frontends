package com.rovinn.backendfrontends.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table (name = "users")
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    @Email (message = "Email must be valid")
    @NotBlank (message = "Email is required")
    private String email;

    @NotBlank (message = "Username is required")
    @Column (nullable = false)
    private String username;

    @Column (nullable = false)
    @NotBlank (message = "Password is required")
    @Size(min = 4, message = "Password must be at least 4 characters")
    private String password;
}

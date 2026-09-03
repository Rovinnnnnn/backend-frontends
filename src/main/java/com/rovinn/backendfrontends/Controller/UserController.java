package com.rovinn.backendfrontends.Controller;

import com.rovinn.backendfrontends.Service.UserServiceInterface;
import com.rovinn.backendfrontends.model.UserLoginDTO;
import com.rovinn.backendfrontends.model.UserRegisterDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    final private UserServiceInterface userService;
    public UserController(UserServiceInterface userService) {
        this.userService = userService;
    }
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserRegisterDTO register) {
        return ResponseEntity.ok(userService.register(register));
    }
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@Valid @RequestBody UserLoginDTO login) {
        return ResponseEntity.ok(userService.login(login));
    }

}

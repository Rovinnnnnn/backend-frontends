package com.rovinn.backendfrontends.Service;

import com.rovinn.backendfrontends.Repository.UserRepository;
import com.rovinn.backendfrontends.model.User;
import com.rovinn.backendfrontends.model.UserLoginDTO;
import com.rovinn.backendfrontends.model.UserRegisterDTO;
import com.rovinn.backendfrontends.model.UserResponseDTO;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserServiceInterface{
    final private UserRepository userRepository;
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserResponseDTO login(UserLoginDTO login) {
        User saved = userRepository.findByEmail(login.getEmail()).orElseThrow(() -> new RuntimeException("User not found"));
        BCryptPasswordEncoder passwordEncode = new BCryptPasswordEncoder();
        if(!passwordEncode.matches(login.getPassword(), saved.getPassword())) {
            throw new RuntimeException("Incorrect password");
        }
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(saved.getId());
        userResponseDTO.setUsername(saved.getUsername());
        return userResponseDTO;
    }
    @Override
    public UserResponseDTO register(UserRegisterDTO register) {
        User created = new User();
        if(userRepository.existsByEmail(register.getEmail())) {
            throw new RuntimeException("User with this email already exists");
        }
        created.setEmail(register.getEmail());
        created.setUsername(register.getUsername());

        BCryptPasswordEncoder passwordEncode = new BCryptPasswordEncoder();
        created.setPassword(passwordEncode.encode(register.getPassword()));
        userRepository.save(created);

        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(created.getId());
        userResponseDTO.setUsername(created.getUsername());
        return userResponseDTO;
    }
}

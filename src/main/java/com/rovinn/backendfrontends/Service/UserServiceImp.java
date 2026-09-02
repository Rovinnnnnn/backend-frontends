package com.rovinn.backendfrontends.Service;

import com.rovinn.backendfrontends.Repository.UserRepository;
import com.rovinn.backendfrontends.model.UserLoginDTO;
import com.rovinn.backendfrontends.model.UserRegisterDTO;
import com.rovinn.backendfrontends.model.UserResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserServiceInterface{
    final private UserRepository userRepository;
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserResponseDTO login(UserLoginDTO login) {
        return null;
    }
    @Override
    public UserResponseDTO register(UserRegisterDTO register) {
        return null;
    }
}

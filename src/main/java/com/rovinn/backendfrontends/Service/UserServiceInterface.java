package com.rovinn.backendfrontends.Service;

import com.rovinn.backendfrontends.model.UserLoginDTO;
import com.rovinn.backendfrontends.model.UserRegisterDTO;
import com.rovinn.backendfrontends.model.UserResponseDTO;

public interface UserServiceInterface {
   UserResponseDTO login(UserLoginDTO login);
   UserResponseDTO register(UserRegisterDTO register);
}

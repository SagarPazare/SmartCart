package com.smartcart.userservice.service;

import com.smartcart.userservice.dto.UserRequest;
import com.smartcart.userservice.dto.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse createUser(UserRequest request);

    List<UserResponse> getAllUsers();

    UserResponse getUserById(Long id);

    UserResponse getUserByEmail(String email);

    UserResponse updateUser(Long id, UserRequest request);

    void deleteUser(Long id);
}
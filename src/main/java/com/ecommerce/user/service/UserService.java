package com.ecommerce.user.service;

import com.ecommerce.user.dto.UserDto;
import com.ecommerce.user.dto.RegisterRequest;
import com.ecommerce.user.entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser(RegisterRequest request);
    UserDto getUserById(Long id);
    UserDto getUserByUsername(String username);
    List<UserDto> getAllUsers();
    List<UserDto> getActiveUsers();
    UserDto updateUser(Long id, UserDto userDto);
    void deleteUser(Long id);
    void deactivateUser(Long id);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}

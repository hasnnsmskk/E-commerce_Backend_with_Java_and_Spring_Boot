package com.workintech.ecommerce.service;

import com.workintech.ecommerce.dto.UserResponse;
import com.workintech.ecommerce.entity.User;

import java.util.List;

public interface UserService {

    List<UserResponse> getAll();
    UserResponse getById(long id);
}
package com.workintech.ecommerce.service;

import com.workintech.ecommerce.dto.DtoConverter;
import com.workintech.ecommerce.dto.UserResponse;
import com.workintech.ecommerce.entity.User;
import com.workintech.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserResponse> getAll() {
        return DtoConverter.convertUserListToUserResponseList(userRepository.findAll());
    }

    @Override
    public UserResponse
    getById(long id) {
       User user = userRepository.findById(id).orElseThrow(() -> {
           throw new RuntimeException("User with given id not exist: " + id);
       });

        return DtoConverter.convertUserToUserResponse(user);
    }
}

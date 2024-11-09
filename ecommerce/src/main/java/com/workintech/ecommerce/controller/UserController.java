package com.workintech.ecommerce.controller;

import com.workintech.ecommerce.dto.UserResponse;
import com.workintech.ecommerce.entity.User;
import com.workintech.ecommerce.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<UserResponse> getAll(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse getById(@PathVariable long id){
        return userService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse saveUser(@RequestBody User user) {
        return  userService.save(user);
    }
}

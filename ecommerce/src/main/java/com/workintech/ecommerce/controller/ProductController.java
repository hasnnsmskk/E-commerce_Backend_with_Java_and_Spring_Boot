package com.workintech.ecommerce.controller;

import com.workintech.ecommerce.dto.UserProductResponse;
import com.workintech.ecommerce.dto.UserResponse;
import com.workintech.ecommerce.entity.Product;
import com.workintech.ecommerce.service.ProductService;
import com.workintech.ecommerce.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private UserService userService;

    private ProductService productService;

    @PostMapping("/save/{userId}")
    public UserProductResponse saveProduct(@PathVariable long userId,
                                           @RequestBody Product product){
    return productService.save(userId, product);

    }
}

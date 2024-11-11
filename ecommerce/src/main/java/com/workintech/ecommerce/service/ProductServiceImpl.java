package com.workintech.ecommerce.service;

import com.workintech.ecommerce.dto.DtoConverter;
import com.workintech.ecommerce.dto.UserProductResponse;
import com.workintech.ecommerce.entity.Product;
import com.workintech.ecommerce.entity.User;
import com.workintech.ecommerce.repository.UserRepository;
import com.workintech.ecommerce.repository.ProductRepository; // Ürünleri kaydetmek için gerekli
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final UserService userService;
    private final ProductRepository productRepository; // Ürün kaydını yapmak için

    @Override
    public UserProductResponse save(long userId, Product product) {
        User foundUser = userService.findById(userId);
        foundUser.addProduct(product);
        product.setUsers(foundUser);
        Product savedPost = productRepository.save(product);
        return  DtoConverter.convertProductToUserProductResponse(savedPost);
    }
}

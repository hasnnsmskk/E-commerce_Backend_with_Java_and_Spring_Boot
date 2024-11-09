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

    private final UserRepository userRepository;
    private final ProductRepository productRepository; // Ürün kaydını yapmak için

    @Override
    public UserProductResponse save(long userId, Product product) {
        Optional<User> foundUser = userRepository.findById(userId);
        if (foundUser.isPresent()) {
            User user = foundUser.get();

            // Kullanıcının ürün listesine ekleme
            user.addProduct(product);

            Product savedProduct = productRepository.save(product); // Ürünü kaydet ve geri döndür
            userRepository.save(user);
            return DtoConverter.convertProductToUserProductResponse(savedProduct);
        } else {
            throw new RuntimeException("User with given id not exist: " + userId);
        }
    }
}

package com.workintech.ecommerce.service;

import com.workintech.ecommerce.dto.UserProductResponse;
import com.workintech.ecommerce.entity.Product;

public interface ProductService {

    UserProductResponse save(long userId, Product product);
}

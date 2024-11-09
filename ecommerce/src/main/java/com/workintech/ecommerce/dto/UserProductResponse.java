package com.workintech.ecommerce.dto;

import java.util.List;


public record UserProductResponse(List<Long> userIds, long productId, String title, String description, Double price) {
}



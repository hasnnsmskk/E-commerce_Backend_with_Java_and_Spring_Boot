package com.workintech.ecommerce.dto;

import com.workintech.ecommerce.entity.Product;
import com.workintech.ecommerce.entity.User;

import java.util.ArrayList;
import java.util.List;

public class DtoConverter {

    public static UserResponse convertUserToUserResponse(User user){
        return new UserResponse(user.getId(), user.getEmail());
    }

    public static List<UserResponse> convertUserListToUserResponseList(List<User> users){

        List<UserResponse> responseList = new ArrayList<>();
        users.forEach(user -> {
            responseList.add(new UserResponse(user.getId(), user.getEmail()));
        });
        return responseList;
    }

    public static UserProductResponse convertProductToUserProductResponse(Product product) {
        List<Long> userIds = new ArrayList<>();
        for (User user : product.getUsers()) {
            userIds.add(user.getId());
        }

        return new UserProductResponse(userIds, product.getId(), product.getTitle(), product.getDescription(), product.getPrice());
    }


}

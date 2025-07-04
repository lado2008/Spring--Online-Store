package com.example.online_store.mappers;

import com.example.online_store.models.user.UserEntity;
import com.example.online_store.models.user.UserRequest;
import com.example.online_store.models.user.UserResponse;

public class UserMapper {
    public static UserEntity mapRequestToEntity(UserRequest userRequest) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(userRequest.getUserName());
        userEntity.setName(userRequest.getName());
        return userEntity;
    }

    public static UserResponse mapEntityToResponse(UserEntity userEntity) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(userEntity.getId());
        userResponse.setUserName(userEntity.getUserName());
        userResponse.setName(userEntity.getName());
        return userResponse;
    }
}

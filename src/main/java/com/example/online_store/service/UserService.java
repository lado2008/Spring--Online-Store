package com.example.online_store.service;

import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.online_store.mappers.UserMapper;
import com.example.online_store.models.user.UserEntity;
import com.example.online_store.models.user.UserRequest;
import com.example.online_store.models.user.UserResponse;
import com.example.online_store.repositories.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity findById(Long userId) {
        Optional<UserEntity> byId = userRepository.findById(userId);
        return byId
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

    public UserResponse createUser(UserRequest userRequest) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(userRequest.getUserName());
        userEntity.setName(userRequest.getName());
        UserEntity save = userRepository.save(userEntity);
        return UserMapper.mapEntityToResponse(save);
    }

    public UserResponse view(Long userId) {
        return UserMapper.mapEntityToResponse(findById(userId));
    }
}

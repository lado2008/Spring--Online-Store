package com.example.online_store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.online_store.models.user.UserEntity;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    // Additional query methods can be defined here if needed

    
}
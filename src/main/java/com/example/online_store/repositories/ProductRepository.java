package com.example.online_store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.online_store.models.product.ProductEntity;


@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}

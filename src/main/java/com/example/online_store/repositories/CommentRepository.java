package com.example.online_store.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.online_store.models.comment.CommentEntity;
import com.example.online_store.models.comment.CommentResponse;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    @Query("""
        select new com.example.online_store.models.comment.CommentResponse(c.id, c.text, c.productEntity.name) from CommentEntity c
        where c.productEntity.id = :productId
    """)
    Page<CommentResponse> findCommentsForProducts(Long productId, Pageable pageable);
}

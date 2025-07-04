package com.example.online_store.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.online_store.mappers.CommentMapper;
import com.example.online_store.models.comment.CommentEntity;
import com.example.online_store.models.comment.CommentRequest;
import com.example.online_store.models.comment.CommentResponse;
import com.example.online_store.models.product.ProductEntity;
import com.example.online_store.repositories.CommentRepository;

@Service
public class CommentService {
    
    private final CommentRepository commentRepository;
    private final ProductService productService;
    
    public CommentService(CommentRepository commentRepository, ProductService productService) {
        this.commentRepository = commentRepository;
        this.productService = productService;
    }

    public Page<CommentResponse> getCommentsForProduct(Long productId, Integer page, Integer size) {
        productService.doesProductExist(productId);

        return commentRepository.findCommentsForProducts(productId, PageRequest.of(page, size, Sort.Direction.DESC, "id"));
    }

    public CommentResponse create(CommentRequest request) {
        ProductEntity productEntity = productService.findById(request.getProductId());
        CommentEntity commentEntity = CommentMapper.mapRequestToEntity(request);
        commentEntity.setProductEntity(productEntity);

        CommentEntity savedComment = commentRepository.save(commentEntity);
        return CommentMapper.mapEntityToResponse(savedComment);
    }
 }

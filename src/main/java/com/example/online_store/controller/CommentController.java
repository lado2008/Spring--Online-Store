package com.example.online_store.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.online_store.models.comment.CommentRequest;
import com.example.online_store.models.comment.CommentResponse;
import com.example.online_store.service.CommentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<CommentResponse> create(@RequestBody @Valid CommentRequest commentRequest) {
        CommentResponse commentResponse = commentService.create(commentRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(commentResponse);
    }

    @GetMapping
    public ResponseEntity<Page<CommentResponse>> findMyProductId(
            @RequestParam("productId") Long productId,
            @RequestParam("page") Integer page,
            @RequestParam("size") Integer size) {
        Page<CommentResponse> comments = commentService.getCommentsForProduct(productId, page, size);
        return ResponseEntity.status(HttpStatus.OK).body(comments);

    }
}

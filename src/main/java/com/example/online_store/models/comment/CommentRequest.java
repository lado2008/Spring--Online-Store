package com.example.online_store.models.comment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class CommentRequest {

    @NotBlank(message = "Comment text cannot be empty")
    @Size(min = 1,max = 512, message = "Comment text cannot exceed 512 characters")
    private String text;

    @Positive(message = "Product ID must be a positive number")
    @NotNull(message = "Product ID cannot be null")
    private Long productId;

    public CommentRequest() {
    }

    public CommentRequest(String text, Long productId) {
        this.text = text;
        this.productId = productId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

}

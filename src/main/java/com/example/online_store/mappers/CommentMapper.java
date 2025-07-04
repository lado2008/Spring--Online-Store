package com.example.online_store.mappers;

import com.example.online_store.models.comment.CommentEntity;
import com.example.online_store.models.comment.CommentRequest;
import com.example.online_store.models.comment.CommentResponse;

public class CommentMapper {
    public static CommentEntity mapRequestToEntity(CommentRequest commentRequest) {
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setText(commentRequest.getText());

        return commentEntity;
    }
    public static CommentResponse mapEntityToResponse(CommentEntity commentEntity) {
        CommentResponse commentResponse = new CommentResponse();
        commentResponse.setId(commentEntity.getId());
        commentResponse.setText(commentEntity.getText());
        commentResponse.setProductName(commentEntity.getProductEntity().getName());

        return commentResponse;
    }
}

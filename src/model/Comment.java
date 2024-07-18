package model;

import enam.CommentType;

import java.util.UUID;

public class Comment {
    private UUID id;
    private UUID postId;
    private UUID userId;
    private String comment;
    private CommentType commentType;

    public Comment() {
        this.id = UUID.randomUUID();
    }

    public Comment(UUID postId, UUID userId, String comment, CommentType commentType) {
        this();
        this.postId = postId;
        this.userId = userId;
        this.comment = comment;
        this.commentType = commentType;
    }

    public UUID getId() {
        return id;
    }

    public UUID getPostId() {
        return postId;
    }

    public void setPostId(UUID postId) {
        this.postId = postId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public CommentType getCommentType() {
        return commentType;
    }

    public void setCommentType(CommentType commentType) {
        this.commentType = commentType;
    }

    @Override
    public String toString() {
        return commentType == CommentType.PARENT_POST ? comment : "\t\t" + comment;
    }
}

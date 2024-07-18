package model;

import java.util.UUID;

public class Post {
    private UUID id;
    private UUID UserId;
    private String post;

    public Post() {
        this.id = id;
    }

    public Post(UUID userId, String post) {
        this();
        UserId = userId;
        this.post = post;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getUserId() {
        return UserId;
    }

    public void setUserId(UUID userId) {
        UserId = userId;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return post;
    }
}

package model;

import java.util.UUID;

public class User {

    private UUID id;
    private String name;
    private String username;
    private String password;
    private String bio;
    private String email;

    public User() {
        this.id = UUID.randomUUID();
    }

    public User(String nickName, String username, String password, String bio, String email) {
        this();
        this.username = username;
        this.name = nickName;
        this.password = password;
        this.bio = bio;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setNickName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

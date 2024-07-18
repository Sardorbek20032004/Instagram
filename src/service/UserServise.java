package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.User;

import java.awt.dnd.DragSource;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserServise {

    private static final String PATH = "src\\file\\users.json";
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();


    public User add(User user) {
        ArrayList<User> users = fileRead();
         if (hasUser(user.getUsername())){
             throw  new IllegalArgumentException("User already exists");
         }
        users.add(user);
        fileWrite(users);
        return user;
    }

    public boolean delete(String username) {
        ArrayList<User> users = fileRead();
        for (User user1 : users) {
            if (user1.getUsername().equals(username)){
                users.remove(user1);
                fileWrite(users);
                return true;
            }
        }
        return false;
    }

    private ArrayList<User> list(){
        return fileRead();
    }

    private boolean hasUser(String username) {
        ArrayList<User> users = fileRead();
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    private void fileWrite(List<User> posts) {
        try (Writer writer = new FileWriter(PATH)) {
            gson.toJson(posts, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<User> fileRead() {
        try (Reader reader = new FileReader(PATH)) {
            Type postListType = new TypeToken<ArrayList<User>>() {
            }.getType();
            ArrayList<User> posts = gson.fromJson(reader, postListType);
            if (posts == null) {
                return new ArrayList<>();
            }
            return posts;
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}

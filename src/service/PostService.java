package service;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Post;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PostService {
    private static final String FILE_PATH = "src\\file\\posts.json";
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    //TODO -> add();
    public Post add(Post post) {
        List<Post> posts = fileRead();
        posts.add(post);
        fileWrite(posts);
        return post;
    }

    //TODO -> update();
    public boolean update(UUID postId, String newPostContent) {
        List<Post> posts = fileRead();
        for (Post post : posts) {
            if (post.getId().equals(postId)) {
                post.setPost(newPostContent);
                fileWrite(posts);
                return true;
            }
        }
        return false;
    }

    //TODO -> delete();
    public boolean delete(UUID postId) {
        List<Post> posts = fileRead();
        for (Post post : posts) {
            if (post.getId().equals(postId)) {
                posts.remove(post);
                fileWrite(posts);
                return true;
            }
        }
        return false;
    }

    //TODO -> list();
    public List<Post> list(UUID id) {
        ArrayList<Post> postArrayList = fileRead();
        ArrayList<Post> posts = new ArrayList<>();
        for (Post post : postArrayList) {
            if (post.getUserId().equals(id)) {
                posts.add(post);
            }
        }
        return posts;

    }

    //TODO -> fileWrite();
    private void fileWrite(List<Post> posts) {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(posts, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //TODO -> fileRead();
    private ArrayList<Post> fileRead() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            Type postListType = new TypeToken<ArrayList<Post>>() {
            }.getType();
            ArrayList<Post> posts = gson.fromJson(reader, postListType);
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

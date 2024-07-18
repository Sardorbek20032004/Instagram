package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Comment;
import model.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.UUID;

public class CommentService {
       private static  final String PATH = "src/file/comments.json";
       private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public void add(Comment comment){
        ArrayList<Comment> comments = fileRead();
        comments.add(comment);
        fileWrite(comments);
    }

    public ArrayList<Comment> listUserId(UUID id){
        ArrayList<Comment> comments = fileRead();
        ArrayList<Comment> commentArrayList = new ArrayList<>();
        for (Comment comment: comments){
            if (comment.getUserId().equals(id)){
                commentArrayList.add(comment);
            }
        }
        return commentArrayList;
    }
    public ArrayList<Comment> listPostId(UUID id){
        ArrayList<Comment> comments = fileRead();
        ArrayList<Comment> commentArrayList = new ArrayList<>();
        for (Comment comment: comments){
            if (comment.getPostId().equals(id)){
                commentArrayList.add(comment);
            }
        }
        return commentArrayList;
    }



    private ArrayList<Comment> fileRead() {
        String s = read();
        Type typeToken = new TypeToken<ArrayList<Comment>>() {}.getType();
        ArrayList<Comment> comments = gson.fromJson(s, typeToken);
        return comments != null ? comments : new ArrayList<>();
    }

    private void fileWrite(ArrayList<Comment> comments) {
        String s = gson.toJson(comments);
        try (FileWriter fileWriter = new FileWriter(PATH)) {
            fileWriter.write(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String read() {
        StringBuilder str = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                str.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str.toString();
    }
}

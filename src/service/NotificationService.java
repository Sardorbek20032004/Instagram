package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Notification;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NotificationService {
    private static final String PATH = "src/file/notifications.json";
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();



    public void addNotification(Notification notification) {
       ArrayList<Notification> notifications = fileRead();
       notifications.add(notification);
       fileWrite(notifications);
    }

    public void markAsRead(UUID notificationId) {
        ArrayList<Notification> notifications = fileRead();
        for (Notification notification : notifications) {
            if (notification.getFromUserId().equals(notificationId)) {
                notification.setStatus(true);
                break;
            }
        }
        fileWrite(notifications);
    }

    public void userViewNotifications(UUID userId) {
        ArrayList<Notification> notifications = fileRead();
        for (Notification notification : notifications) {
            if (notification.getToUserId().equals(userId)) {
                notification.setStatus(false);
            }
        }
        fileWrite(notifications);
    }

    public List<Notification> getNotifications(UUID id) {
        ArrayList<Notification> notifications = fileRead();
        ArrayList<Notification> notificationArrayList = new ArrayList<>();
        for (Notification notification: notifications){
            if (notification.getFromUserId().equals(id) && notification.isStatus()){
                notificationArrayList.add(notification);
            }
        }
        return notificationArrayList;
    }


    private void fileWrite(List<Notification> notifications) {
        String json = gson.toJson(notifications);
        try (FileWriter writer = new FileWriter(PATH)) {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<Notification> fileRead() {
        StringBuilder json = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                json.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Type typeToken = new TypeToken<List<Notification>>() {}.getType();
        ArrayList<Notification> notifications = gson.fromJson(json.toString(), typeToken);
        if (notifications == null) {
            notifications = new ArrayList<>();
        }
        return notifications;
    }
}

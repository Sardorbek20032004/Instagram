package model;
import java.util.UUID;
public class Notification {
    private UUID fromUserId;
    private UUID toUserId;
    private boolean status;
    private UUID postId;

    public Notification(UUID fromUserId, UUID toUserId, boolean status, UUID postId) {
        this.fromUserId = fromUserId;
        this.toUserId = toUserId;
        this.status = status;
        this.postId = postId;
    }

    public UUID getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(UUID fromUserId) {
        this.fromUserId = fromUserId;
    }

    public UUID getToUserId() {
        return toUserId;
    }

    public void setToUserId(UUID toUserId) {
        this.toUserId = toUserId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public UUID getPostId() {
        return postId;
    }

    public void setPostId(UUID postId) {
        this.postId = postId;
    }
}

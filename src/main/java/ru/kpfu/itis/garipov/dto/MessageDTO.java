package ru.kpfu.itis.garipov.dto;

public class MessageDTO {
    private int id;
    private int userId;
    private int recipientId;
    private String content;

    public MessageDTO(int id, int userId, int recipientId, String content) {
        this.id = id;
        this.userId = userId;
        this.recipientId = recipientId;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(int recipientId) {
        this.recipientId = recipientId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

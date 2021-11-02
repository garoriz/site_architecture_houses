package ru.kpfu.itis.garipov.dto;

public class ArticleDTO {
    private int id;
    private int userId;
    private String heading;
    private String content;

    public ArticleDTO(int id, int userId, String heading, String content) {
        this.id = id;
        this.userId = userId;
        this.heading = heading;
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

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

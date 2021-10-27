package ru.kpfu.itis.garipov.model;

public class Article {
    private int id;
    private int userId;
    private String date;
    private String heading;
    private String content;
    private String urlPhoto;

    public Article(int id, int userId, String date, String heading, String content, String urlPhoto) {
        this.id = id;
        this.userId = userId;
        this.date = date;
        this.heading = heading;
        this.content = content;
        this.urlPhoto = urlPhoto;
    }

    public Article(int userId, String date, String heading, String content, String urlPhoto) {
        this.userId = userId;
        this.date = date;
        this.heading = heading;
        this.content = content;
        this.urlPhoto = urlPhoto;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }
}

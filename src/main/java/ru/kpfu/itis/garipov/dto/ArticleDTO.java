package ru.kpfu.itis.garipov.dto;

public class ArticleDTO {
    private int id;
    private String heading;
    private String content;
    private String date;

    public ArticleDTO(int id, String heading, String content, String date) {
        this.id = id;
        this.heading = heading;
        this.content = content;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getHeading() {
        return heading;
    }

    public String getContent() {
        return content;
    }

    public String getDate() {
        return date;
    }
}

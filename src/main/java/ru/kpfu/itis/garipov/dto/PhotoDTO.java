package ru.kpfu.itis.garipov.dto;

public class PhotoDTO {
    private int id;
    private int userId;
    private String urlPhoto;

    public PhotoDTO(int id, int userId, String urlPhoto) {
        this.id = id;
        this.userId = userId;
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

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }
}

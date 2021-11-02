package ru.kpfu.itis.garipov.model;

public class SaleAd {
    private int id;
    private int userId;
    private String heading;
    private String content;
    private int price;
    private String phoneNumber;
    private String urlPhoto;

    public SaleAd(int id, int userId, String heading, String content, int price, String phoneNumber, String urlPhoto) {
        this.id = id;
        this.userId = userId;
        this.heading = heading;
        this.content = content;
        this.price = price;
        this.phoneNumber = phoneNumber;
        this.urlPhoto = urlPhoto;
    }

    public SaleAd(int userId, String heading, String content, int price, String phoneNumber, String urlPhoto) {
        this.userId = userId;
        this.heading = heading;
        this.content = content;
        this.price = price;
        this.phoneNumber = phoneNumber;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }
}

package ru.kpfu.itis.garipov.dto;

public class SaleAdDTO {
    private int id;
    private String heading;
    private String content;
    private int price;
    private String phoneNumber;
    private String date;

    public SaleAdDTO(int id, String heading, String content, int price, String phoneNumber, String date) {
        this.id = id;
        this.heading = heading;
        this.content = content;
        this.price = price;
        this.phoneNumber = phoneNumber;
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

    public int getPrice() {
        return price;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getDate() {
        return date;
    }
}

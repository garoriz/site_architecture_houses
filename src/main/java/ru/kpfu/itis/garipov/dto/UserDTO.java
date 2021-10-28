package ru.kpfu.itis.garipov.dto;

public class UserDTO {
    private int id;
    private String name;
    private String surname;
    private String status;
    private String urlPhoto;
    private String login;
    private String password;

    public UserDTO(int id, String name, String surname, String status, String urlPhoto, String login, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.status = status;
        this.urlPhoto = urlPhoto;
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package ru.kpfu.itis.garipov.dto;

public class UserDTO {
    private int id;
    private String name;
    private String surname;
    private String status;

    public UserDTO(int id, String name, String surname, String status) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getStatus() {
        return status;
    }
}

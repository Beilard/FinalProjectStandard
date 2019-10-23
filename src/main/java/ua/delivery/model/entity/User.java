package ua.delivery.model.entity;

import java.util.Date;

public class User {
    private Integer id;
    private String email;
    private String password;
    private String name;
    private String surname;
    private Date dateOfBirth;

    public User(Integer id, String email, String password, String name, String surname, Date dateOfBirth) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }
}

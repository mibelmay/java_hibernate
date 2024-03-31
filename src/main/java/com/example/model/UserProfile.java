package com.example.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserProfile {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "login", unique = true)
    private String login;
    @Column(name = "pass")
    private String password;
    @Column(name = "email")
    private String email;

    public UserProfile(String login, String password, String email) {
        //this.id = -1;
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public UserProfile() {
    }

    public long getId() {
        return id;
    }
    public String getLogin() {
        return login;
    }
    public String getPassword() {
        return password;
    }
    public String getEmail() {
        return email;
    }
    @Override
    public String toString() {
        return "UserDataSet{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

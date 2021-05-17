package com.example.electrobank.model;

import java.io.Serializable;

public class UserDetails extends User implements Serializable {
    private String id;

    public UserDetails(String firstName, String lastName, String email, String password, String id) {
        super(firstName, lastName, email, password);
        this.id = id;
    }
    public UserDetails(String firstName, String lastName, String email, String password) {
        super(firstName, lastName, email, password);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

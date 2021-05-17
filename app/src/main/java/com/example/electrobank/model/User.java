package com.example.electrobank.model;

import java.io.Serializable;

public class User implements Serializable {
    public final String firstName;
    public final String lastName;
    public final String email ;
    public final String password;

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}

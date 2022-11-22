package com.nhnacademy.edu.jdbc1.domain;

import lombok.Getter;

import java.util.Date;

@Getter
public class User {
    private final Long id;
    private final String username;
    private final String password;
    private final Date timestamp;

    public User(Long id, String username, String password, Date timestamp) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}

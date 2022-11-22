package com.nhnacademy.edu.jdbc1.domain;

import lombok.Getter;

import java.util.Date;

@Getter
public class Teacher {
    private final Long id;
    private final String name;
    private final Date timestamp;

    public Teacher(Long id, String name, Date timestamp) {
        this.id = id;
        this.name = name;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}

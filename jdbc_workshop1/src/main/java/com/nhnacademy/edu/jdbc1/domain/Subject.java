package com.nhnacademy.edu.jdbc1.domain;

import lombok.Getter;

import java.util.Date;

public class Subject {
    @Getter
    private final Long id;

    @Getter
    private final String name;

    @Getter
    private final Date timestamp;

    public Subject(Long id, String name, Date timestamp) {
        this.id = id;
        this.name = name;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}

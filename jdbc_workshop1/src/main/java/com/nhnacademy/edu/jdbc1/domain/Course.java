package com.nhnacademy.edu.jdbc1.domain;

import com.nhnacademy.edu.jdbc1.domain.Subject;
import com.nhnacademy.edu.jdbc1.domain.Teacher;
import lombok.Getter;

import java.util.Date;

@Getter
public class Course {
    private final long id;

    private final Teacher teacher;

    private final Subject subject;

    private final Date timestamp;

    public Course(long id, Teacher teacher, Subject subject, Date timestamp) {
        this.id = id;
        this.teacher = teacher;
        this.subject = subject;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", teacher=" + teacher +
                ", subject=" + subject +
                ", timestamp=" + timestamp +
                '}';
    }
}

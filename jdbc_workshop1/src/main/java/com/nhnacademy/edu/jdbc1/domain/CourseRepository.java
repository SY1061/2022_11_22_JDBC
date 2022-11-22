package com.nhnacademy.edu.jdbc1.domain;

import com.nhnacademy.edu.jdbc1.domain.Course;

import java.sql.Connection;
import java.util.List;

public interface CourseRepository {
    List<Course> findAll();

    Course findByID(Long id);

    int insert(Course course);

    int updateCourse(Course course);

    int deleteById(Long id);
}

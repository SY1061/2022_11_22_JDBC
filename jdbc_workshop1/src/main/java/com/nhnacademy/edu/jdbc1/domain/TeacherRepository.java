package com.nhnacademy.edu.jdbc1.domain;

import java.util.List;

public interface TeacherRepository {
    List<Teacher> findAll();

    Teacher findByID(Long id);

    int insert(Teacher teacher);

    int deleteById(Long id);
}

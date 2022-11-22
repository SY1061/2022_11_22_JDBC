package com.nhnacademy.edu.jdbc1.domain;

import com.nhnacademy.edu.jdbc1.domain.Subject;

import java.sql.Connection;
import java.util.List;

public interface SubjectRepository {
    List<Subject> findAll();

    Subject findByID(Long id);

    int insert(Subject subject);

    int deleteById(Long id);
}

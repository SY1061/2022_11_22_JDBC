package com.nhnacademy.edu.jdbc1.domain;

import com.nhnacademy.edu.jdbc1.domain.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();

    User findByID(Long id);

    User findByName(String username);

    boolean matches(String id, String password);
}

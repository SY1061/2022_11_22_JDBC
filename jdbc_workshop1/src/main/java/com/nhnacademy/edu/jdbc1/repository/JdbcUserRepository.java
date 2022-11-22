package com.nhnacademy.edu.jdbc1.repository;

import com.nhnacademy.edu.jdbc1.domain.User;
import com.nhnacademy.edu.jdbc1.domain.UserRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcUserRepository implements UserRepository {
    private final JdbcTemplate jdbcTemplate;

    public JdbcUserRepository(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(
                "select id, username, password, created_at from JdbcUsers",
                (resultSet, rowNum) ->
                        new User(resultSet.getLong("id"),
                                resultSet.getString("username"),
                                resultSet.getString("password"),
                                resultSet.getTimestamp("created_at")));
    }

    @Override
    public User findByID(Long id) {
            return jdbcTemplate.queryForObject(
                    "select id, username, password, created_at from JdbcUsers  where id = ?",
                    (resultSet, rowNum) ->
                            new User(resultSet.getLong("id"),
                                    resultSet.getString("username"),
                                    resultSet.getString("password"),
                                    resultSet.getTimestamp("created_at")),
                    id);
    }

    @Override
    public User findByName(String username) {
        return jdbcTemplate.queryForObject(
                "select id, username, password, created_at from JdbcUsers  where username = ?",
                (resultSet, rowNum) ->
                        new User(resultSet.getLong("id"),
                                resultSet.getString("username"),
                                resultSet.getString("password"),
                                resultSet.getTimestamp("created_at")),
                username);
    }

    @Override
    public boolean matches(String username, String password) {
        return Optional.ofNullable(findByName(username))
                .map(user -> user.getPassword().equals(password))
                .orElse(false);
    }
}

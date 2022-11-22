package com.nhnacademy.edu.jdbc1.repository;

import com.nhnacademy.edu.jdbc1.domain.Subject;
import com.nhnacademy.edu.jdbc1.domain.SubjectRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class JdbcSubjectRepository implements SubjectRepository {
    private final JdbcTemplate jdbcTemplate;

    public JdbcSubjectRepository(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Subject> findAll() {
        return jdbcTemplate.query(
                "select id, name, created_at from JdbcSubjects",
                (resultSet, rowNum) ->
                        new Subject(resultSet.getLong("id"),
                                resultSet.getString("name"),
                                resultSet.getTimestamp("created_at")));
    }

    @Override
    public Subject findByID(Long id) {
        return jdbcTemplate.queryForObject(
                "select id, name, created_at from JdbcSubjects  where id = ?",
                (resultSet, rowNum) ->
                        new Subject(resultSet.getLong("id"),
                                resultSet.getString("name"),
                                resultSet.getTimestamp("created_at")),
                id);
    }

    @Override
    public int insert(Subject subject) {
        return jdbcTemplate.update(
                "INSERT INTO JdbcSubjects(id, name, created_at) VALUES (?,?,?)",
                subject.getId(),
                subject.getName(),
                subject.getTimestamp()
        );
    }

    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update(
                "DELETE FROM JdbcSubjects WHERE id=?",
                id
        );
    }
}

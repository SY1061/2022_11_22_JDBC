package com.nhnacademy.edu.jdbc1.repository;

import com.nhnacademy.edu.jdbc1.domain.Subject;
import com.nhnacademy.edu.jdbc1.domain.SubjectRepository;
import com.nhnacademy.edu.jdbc1.domain.Teacher;
import com.nhnacademy.edu.jdbc1.domain.TeacherRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class JdbcTeacherRepository implements TeacherRepository {
    private final JdbcTemplate jdbcTemplate;

    public JdbcTeacherRepository(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Teacher> findAll() {
        return jdbcTemplate.query(
                "select id, name, created_at from JdbcTeachers",
                (resultSet, rowNum) ->
                        new Teacher(resultSet.getLong("id"),
                                resultSet.getString("name"),
                                resultSet.getTimestamp("created_at")));
    }

    @Override
    public Teacher findByID(Long id) {
        return jdbcTemplate.queryForObject(
                "select id, name, created_at from JdbcTeachers  where id = ?",
                (resultSet, rowNum) ->
                        new Teacher(resultSet.getLong("id"),
                                resultSet.getString("name"),
                                resultSet.getTimestamp("created_at")),
                id);
    }

    @Override
    public int insert(Teacher teacher) {
        return jdbcTemplate.update(
                "INSERT INTO JdbcTeachers(id, name, created_at) VALUES (?,?,?)",
                teacher.getId(),
                teacher.getName(),
                teacher.getTimestamp()
        );
    }

    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update(
                "DELETE FROM JdbcTeachers WHERE id=?",
                id
        );
    }
}

package com.nhnacademy.edu.jdbc1.repository;

import com.nhnacademy.edu.jdbc1.domain.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCourseRepository implements CourseRepository {
    private final JdbcTemplate jdbcTemplate;
    private final TeacherRepository teacherRepository;
    private final SubjectRepository subjectRepository;

    public JdbcCourseRepository(DataSource dataSource, TeacherRepository teacherRepository,
                                SubjectRepository subjectRepository){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.teacherRepository = teacherRepository;
        this.subjectRepository = subjectRepository;
    }
//    String sql = "SELECT c.id as c_id, c.teacher_id, c.subject_id, c.created_at as c_created_at, \n" +
//            "s.id as s_id, s.name as s_name, s.created_at as s_created_at, \n" +
//            "t.id as t_id, t.name as t_name, t.created_at as t_created_at \n" +
//            "FROM JdbcCourses as c \n" +
//            "INNER JOIN JdbcSubjects as s ON c.subject_id = s.id \n" +
//            "INNER JOIN JdbcTeachers as t ON c.teacher_id = t.id;";

    @Override
    public List<Course> findAll() {
        return jdbcTemplate.query(
                "select id, teacher_id, subject_id, created_at from JdbcCourses",
                (resultSet, rowNum) ->
                        new Course(resultSet.getLong("id"),
                                teacherRepository.findByID(resultSet.getLong("teacher_id")),
                                subjectRepository.findByID(resultSet.getLong("subject_id")),
                                resultSet.getTimestamp("created_at")));
    }

    @Override
    public Course findByID(Long id) {
        return jdbcTemplate.queryForObject(
                "select id, teacher_id, subject_id, created_at from JdbcCourses where id = ?",
                (resultSet, rowNum) ->
                        new Course(resultSet.getLong("id"),
                                teacherRepository.findByID(resultSet.getLong("teacher_id")),
                                subjectRepository.findByID(resultSet.getLong("subject_id")),
                                resultSet.getTimestamp("created_at")),
                id);
    }

    @Override
    public int insert(Course course) {
        return jdbcTemplate.update(
                "INSERT INTO JdbcCourses(teacher_id, subject_id, created_at) VALUES (,?,?,?)",
                course.getTeacher().getId(),
                course.getSubject().getId(),
                course.getTimestamp()
        );
    }

    @Override
    public int updateCourse(Course course) {
        return jdbcTemplate.update(
                "UPDATE JdbcCourses SET teacher_id=?, subject_id=? where id=?",
                course.getTeacher().getId(),
                course.getSubject().getId(),
                course.getId()
        );
    }

    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update(
                "DELETE FROM JdbcCourses WHERE id=?",
                id
        );
    }
}

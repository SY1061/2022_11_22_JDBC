package com.nhnacademy.edu.jdbc1.controller;

import com.nhnacademy.edu.jdbc1.domain.Course;
import com.nhnacademy.edu.jdbc1.domain.CourseRepository;
import com.nhnacademy.edu.jdbc1.domain.SubjectRepository;
import com.nhnacademy.edu.jdbc1.domain.TeacherRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Controller
public class RegisterController {
    private final CourseRepository courseRepository;

    private final TeacherRepository teacherRepository;

    private final SubjectRepository subjectRepository;

    public RegisterController(CourseRepository courseRepository, TeacherRepository teacherRepository,
                              SubjectRepository subjectRepository){
        this.courseRepository = courseRepository;
        this.teacherRepository = teacherRepository;
        this.subjectRepository = subjectRepository;
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public String doRegister(@RequestParam("id") Long id,
            @RequestParam("teacherId") Long teacherId,
            @RequestParam("subjectId") Long subjectId,
            HttpServletRequest request,
                             HttpServletResponse response){
        Course course = new Course(id, teacherRepository.findByID(teacherId),
                subjectRepository.findByID(subjectId), new Date());
        courseRepository.insert(course);
        request.getServletContext().setAttribute("courseRepositoryList", courseRepository.findAll());

        return "subject";
    }


}

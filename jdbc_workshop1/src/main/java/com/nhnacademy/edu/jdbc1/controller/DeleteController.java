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
public class DeleteController {
    private final CourseRepository courseRepository;

    private final TeacherRepository teacherRepository;

    private final SubjectRepository subjectRepository;

    public DeleteController(CourseRepository courseRepository, TeacherRepository teacherRepository,
                            SubjectRepository subjectRepository){
        this.courseRepository = courseRepository;
        this.teacherRepository = teacherRepository;
        this.subjectRepository = subjectRepository;
    }

    @GetMapping("/delete")
    public String register(){
        return "delete";
    }

    @PostMapping("/delete")
    public String doRegister(@RequestParam("id") Long id,
            HttpServletRequest request,
                             HttpServletResponse response){
        courseRepository.deleteById(id);
        request.getServletContext().setAttribute("courseRepositoryList", courseRepository.findAll());

        return "subject";
    }


}

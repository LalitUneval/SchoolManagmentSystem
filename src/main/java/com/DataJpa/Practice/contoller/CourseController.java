package com.DataJpa.Practice.contoller;

import com.DataJpa.Practice.entity.Course;
import com.DataJpa.Practice.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private  CourseService courseService;

    @PostMapping
    public Course addCourse(@RequestBody Course course){
        return courseService.addCourse(course);
    }

    @GetMapping
    public List<Course> getAllCourse(){
        return courseService.getAllCourse();
    }

    //add the course with the teacher and it material
    @PostMapping("/addWithTeacher")
    public Course addCourseWithTeacherAndMaterial(@RequestBody Course course){
        return courseService.addCourseWithTeacherMaterial(course);
    }
    @PostMapping("/save")
    public Course saveCourse(@RequestBody Course course) {
        return courseService.saveCourse(course);
    }
}

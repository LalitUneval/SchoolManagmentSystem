package com.DataJpa.Practice.service;

import com.DataJpa.Practice.entity.Course;
import com.DataJpa.Practice.entity.CourseMaterial;
import com.DataJpa.Practice.entity.Student;
import com.DataJpa.Practice.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course addCourse(Course course){
        return courseRepository.save(course);
    }
    public List<Course> getAllCourse(){
        return courseRepository.findAll();
    }

    // add the course with teacher and course material
    public Course addCourseWithTeacherMaterial(Course course){
        //here we first save the course
        CourseMaterial courseMaterial =course.getCourseMaterial();
        if(courseMaterial!=null){
            courseMaterial.setCourse(course);
        }
        return courseRepository.save(course);
    }
    //add full course with the teacher and the student
    public Course saveCourse(Course course) {
        // No need to loop and add again

        CourseMaterial courseMaterial = course.getCourseMaterial();
        if (courseMaterial != null) {
            courseMaterial.setCourse(course);
        }

        return courseRepository.save(course);
    }

}

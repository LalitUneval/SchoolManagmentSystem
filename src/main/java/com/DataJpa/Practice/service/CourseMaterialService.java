package com.DataJpa.Practice.service;

import com.DataJpa.Practice.entity.Course;
import com.DataJpa.Practice.entity.CourseMaterial;
import com.DataJpa.Practice.repository.CourseMaterialRepository;
import com.DataJpa.Practice.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseMaterialService {


    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    public CourseMaterial addCourseMaterial(Long courseId , String url){
        Course course= courseRepository.findById(courseId)
                .orElseThrow(()->new RuntimeException("Course is not Found using "+courseId));

        CourseMaterial courseMaterial =CourseMaterial.builder()
                .url(url)
                .course(course)
                .build();
        return courseMaterialRepository.save(courseMaterial);
    }


    //printing all the course

    public List<CourseMaterial> getAllCourseMaterial(){
        return courseMaterialRepository.findAll();
    }

}

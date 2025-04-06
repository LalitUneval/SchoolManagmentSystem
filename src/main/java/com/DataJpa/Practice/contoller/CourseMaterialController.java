package com.DataJpa.Practice.contoller;
import com.DataJpa.Practice.entity.CourseMaterial;
import com.DataJpa.Practice.service.CourseMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courseMaterials")
public class CourseMaterialController {
    @Autowired
    private CourseMaterialService courseMaterialService;
    //add of the course
    @PostMapping
    public CourseMaterial addCourse(@RequestBody CourseMaterial courseMaterial){
        return courseMaterialService.addCourseMaterial(courseMaterial.getCourse().getCourseId(),courseMaterial.getUrl());

    }
    @GetMapping
    public List<CourseMaterial>  getAllCourseMaterial(){
        return courseMaterialService.getAllCourseMaterial();
    }
}

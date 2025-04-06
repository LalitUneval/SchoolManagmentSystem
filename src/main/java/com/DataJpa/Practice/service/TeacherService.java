package com.DataJpa.Practice.service;

import com.DataJpa.Practice.entity.Teacher;
import com.DataJpa.Practice.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;
    //adding of the courser

    public Teacher addTeacher(Teacher teacher){
        return teacherRepository.save(teacher);

    }
}

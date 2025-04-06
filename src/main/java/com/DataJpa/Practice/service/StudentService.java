package com.DataJpa.Practice.service;

import com.DataJpa.Practice.entity.Student;
import com.DataJpa.Practice.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public  List<Student> findByFirstLetter(String name) {
        return studentRepository.findByFirstNameContaining(name);
    }

    //adding of the student
    public Student addStduent(Student student){
       return  studentRepository.save(student);
    }
    //display the student
    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }


    //find the student by the first name
    public List<Student> findByFirstName(String name){
        return studentRepository.findByFirstName(name);
    }

    public Student getStudentByEmail(String email) {
        return studentRepository.getStudentByEmailAddress(email);
    }
    public String getStudentFirstNameByEmail(String emailId) {
       return  studentRepository.getStudentFirstNameByEmailAddress(emailId);

    }

    public String getStudentLastNameByEmailAddress(String emailId){
        return studentRepository.getStudentLastNameByEmailAddress(emailId);
    }
    public Student getStudentByFirstAndEmail(String firstName ,String email){
        return studentRepository.findByFirstNameAndEmail(firstName , email);
    }
    // when we used the any update and delete type query then we used the transcation
    @Transactional
    public  int updateStudentNameByEmailId(String firstName, String email){
        return studentRepository.updateStudentNameByEmailId(firstName, email);
    }

}

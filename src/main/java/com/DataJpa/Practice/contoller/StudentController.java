package com.DataJpa.Practice.contoller;

import com.DataJpa.Practice.entity.Student;
import com.DataJpa.Practice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public Student addStudent(@RequestBody Student student){
        return studentService.addStduent(student);
    }

    @GetMapping
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }
    @GetMapping("/firstname/{name}")
    public List<Student> findByFirstName(@PathVariable String name) {
        return studentService.findByFirstName(name);
    }

    @GetMapping("/letter/{name}")
    public List<Student> findByLetter(@PathVariable String name) {
        return studentService.findByFirstLetter(name);
    }

    @GetMapping("/email/{email}")
    public Student getStudentByEmail(@PathVariable String email) {
        return studentService.getStudentByEmail(email);
    }

    @GetMapping("/firstname-by-email/{email}")
    public String getFirstNameByEmail(@PathVariable String email) {
        return studentService.getStudentFirstNameByEmail(email);
    }
    @GetMapping("/last-name/{email}")
    public String getStudentLastNameByEmailAddress(@PathVariable String  email){
        return studentService.getStudentLastNameByEmailAddress(email);
    }
    @GetMapping("/first_name/email_id")
    public Student getStudentFirstNameAndLastName(@RequestBody Student std){
        return studentService.getStudentByFirstAndEmail(std.getFirstName(),std.getEmailId());
    }

    @PostMapping("/updateFirstName")
    public int updateStudentNameByEmailId(@RequestBody Student std){
        return studentService.updateStudentNameByEmailId(std.getFirstName() , std.getEmailId());
    }
}

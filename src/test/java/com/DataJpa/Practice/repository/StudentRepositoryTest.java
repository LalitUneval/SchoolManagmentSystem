package com.DataJpa.Practice.repository;

import com.DataJpa.Practice.entity.Guardian;
import com.DataJpa.Practice.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Guardian guardian = Guardian.builder()
                .email("bharat@gmail.com")
                .mobile("1234567891")
                .name("Bharatbhai")
                .build();

        Student student = Student.builder()
                .emailId("unevallalit6499@gmail.com")
                .firstName("Lalit")
                .lastName("Uneval")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println(studentList);
    }
}

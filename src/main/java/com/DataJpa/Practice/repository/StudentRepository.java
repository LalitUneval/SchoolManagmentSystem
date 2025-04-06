package com.DataJpa.Practice.repository;

import com.DataJpa.Practice.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student ,Long> {


    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String name); // Corrected here


    //we can get the value using the query also
    //jpql
    //emailId and Student is as per the Entity name not like in the database
    @Query("select s from Student s where s.emailId=?1")
    Student getStudentByEmailAddress(String emailId);


    // if i want to select firstName where the emailID=? then we used this
    @Query("select s.firstName from Student s where s.emailId=?1")
    String  getStudentFirstNameByEmailAddress(String emailId);

    // we can write the native query also
    // native query means simple sql query
    //just we get the last when the user enter the
    @Query(
            value = "select last_name from student s where s.email_address=?1",
            nativeQuery = true
    )
    String getStudentLastNameByEmailAddress(String emailId);

//    instead of writing the ?1 we can used the param
    @Query(
            value = "SELECT * FROM student WHERE first_name = :firstName AND email_address = :email",
            nativeQuery = true
    )
    Student findByFirstNameAndEmail(@Param("firstName") String firstName, @Param("email") String email);

    // when we used the any update delete query then apply the modified
    @Modifying
    @Query(
            value = "update student set first_name=?1 where email_address=?2",
            nativeQuery = true
    )
    int updateStudentNameByEmailId(String firstName , String emailId);


}

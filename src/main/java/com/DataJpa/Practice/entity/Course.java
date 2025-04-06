package com.DataJpa.Practice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
public class Course {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long courseId;
    private String title;
    private Integer credit;
    //for the bidrection we need to add this
    @JsonBackReference
    @OneToOne(mappedBy = "course",fetch = FetchType.EAGER,cascade =CascadeType.ALL)
    private CourseMaterial courseMaterial;
    // we can make the many to one relation it is always prefer that we used this rather then the one to many

    @ManyToOne(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="teacher_id",referencedColumnName = "teacherId")
    private Teacher teacher;

    // here we are creating the many to many relationship
    //many student have the many course
    //for the one to many or wise versa there is only the fk is add but here we have the third table
    // which join the both the table
    @ManyToMany
    //here we used the join tabel
    @JoinTable(
            name = "student_course_map",
            joinColumns = @JoinColumn(
                    name = "course_id",
                    referencedColumnName = "courseId"
            )//this is join column define the Student having the course know inversion also we make the
            //define we make the course haveing the student
            ,
            inverseJoinColumns = @JoinColumn(
                    name = "student_id",
                    referencedColumnName = "studentId"
            )
    )
    private List<Student> students;

    public void addStudents(Student student){
        if(students==null) students =new ArrayList<>();
        students.add(student);
    }
}

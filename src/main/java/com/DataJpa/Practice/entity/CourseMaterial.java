package com.DataJpa.Practice.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class CourseMaterial {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long courseMaterialId;
    private String url;

    @JsonManagedReference
    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            //upto here if we add course without it material then it allow
            // but we need not allowed it must have the course material so we add
            //optional = false by default it is true
            optional = false
    )
    @JoinColumn(
            name = "course_id",//name of the fk(name of the column)// in this table we have one more column
            //by name course_id
            referencedColumnName = "courseId"//which column we need to define the fk

    )
    //upto this it is uniDirection mapping
    private Course course;





}

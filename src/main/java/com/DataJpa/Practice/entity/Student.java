package com.DataJpa.Practice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(
        name="student"
        //this we can used of the making something the unique
        // if we used coloum(unique_true ) then there is no need to write
//        ,uniqueConstraints = @UniqueConstraint(
//                name = "emailid_unique",
//                columnNames = "email_address"
//        )

)
public class Student {


    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long studentId;
    private String firstName;
    private String lastName;

    //for the name the coloum , and we need to make it as the unique

    @Column(
            name="email_address",
            nullable = false,//means very time the user must enter the email different
            unique = true// when we write this then there is no need to write the uniue contratin
            // it must unique in the all the row
    )
    private String emailId;

    @Embedded
    private Guardian guardian;

}

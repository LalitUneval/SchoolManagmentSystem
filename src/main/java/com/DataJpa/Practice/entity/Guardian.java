package com.DataJpa.Practice.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//we do not need to make this entity but we need to used this of we used the Em
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
// has we have the different attribute name like : name for the gurardian name like this for mapping
// this we used thius
@AttributeOverrides({
        @AttributeOverride(
                name="name",
                column = @Column(name = "guardian_name")
        ),
        @AttributeOverride(
                name ="email",
                column = @Column(name = "guardian_email")
        ),
        @AttributeOverride(
                name = "mobile",
                column = @Column(name = "guardian_mobile")
        )

})

public class Guardian {


    private String name;
    private String email;
    private String mobile;
}

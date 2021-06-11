package net.iqbusiness.buhle.onlineregistrationapp.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Person {

    @Id
    @SequenceGenerator(name = "person_sequence", sequenceName = "person_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_sequence")
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "first_name", nullable = false, columnDefinition = "varchar(25)")
    private String firstName;

    @Column(name = "last_name", nullable = false, columnDefinition = "varchar(20)")
    private String lastName;

    @Column(name = "id_number", nullable = false, unique = true, updatable = false, columnDefinition = "varchar(13)")
    @Size(min = 13, max = 13, message = "Id Number must equal 13 digits")
    private String idNumber;

    @Column(name = "contact_number", nullable = false, columnDefinition = "varchar(10)")
    @Size(min = 10, max = 10, message = "contact number must equal 10 digits")
    private String contactNumber;
}

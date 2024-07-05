package net.javaguides.ms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter //to generate the getter method for these instance variables.
@Setter
@NoArgsConstructor // to create no args constructor
@AllArgsConstructor //to create parameterized  constructor
@Entity  //to specify a class as a jp entity
@Table (name= "employee") // to specify table detail
public class Employee {

    @Id
    //column id is used from other table
    @Column(name ="Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //database auto increment feature
    private Long id;
    @Column(name= "first_Name")  //annotate nm field with add column annotation to configuration column nm
    private String firstName;
    @Column(name= "last_Name")
    private String lastName;
    @Column(name= "email_id",nullable = false,unique = true)

    private String email;
    private String emailId;


}

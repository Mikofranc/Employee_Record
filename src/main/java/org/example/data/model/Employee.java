package org.example.data.model;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}

package org.example.dto;

import lombok.Data;

@Data
public class CreateEmployeeRequest {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
}

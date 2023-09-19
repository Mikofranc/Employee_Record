package org.example.dto;

import lombok.Data;

@Data
public class CreateEmployeeResponse {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
}

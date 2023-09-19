package org.example.dto;

import lombok.Data;

@Data
public class UpdateEmployeeRequest {
    private  long id;
    private String firstName;
    private String newName;
    private String newLastName;
    private String newEmail;
}

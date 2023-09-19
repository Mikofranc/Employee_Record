package org.example.dto;

import lombok.Data;

@Data
public class DeleteEmloyeeResponse {
    private long id;
    private final String MESSAGE = "successful";
}

package org.example.service;

import org.example.data.model.Employee;
import org.example.dto.*;

public interface EmployeeInterface {
    CreateEmployeeResponse addEmployee(CreateEmployeeRequest request);
    UpdateEmployeeResponse updateUployee(UpdateEmployeeRequest request);
    DeleteEmloyeeResponse deleteEmployee(DeleteEmloyeeRequest request);
    public Employee findEmployeeByName(String name);
}

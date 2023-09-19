package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.data.model.Employee;
import org.example.data.repository.EmployeeRepo;
import org.example.dto.*;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class EmployeeService implements EmployeeInterface{
  //  @Autowired
    private final EmployeeRepo employeeRepo;
    @Override
    public CreateEmployeeResponse addEmployee(CreateEmployeeRequest request){
        Employee employee = new Employee();
        employee.setEmail(request.getEmail());
        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        Employee newEmployee = employeeRepo.save(employee);

        CreateEmployeeResponse response = new CreateEmployeeResponse();
        response.setId(newEmployee.getId());
        response.setEmail(newEmployee.getEmail());
        response.setFirstName(newEmployee.getFirstName());
        response.setLastName(newEmployee.getLastName());
        return  response;
    }
    @Override
    public UpdateEmployeeResponse updateUployee(UpdateEmployeeRequest request){
        var employee = employeeRepo.findEmployeeByFirstName(request.getFirstName());
        employee.setFirstName(request.getNewName());
        employee.setLastName(request.getNewLastName());
        employee.setEmail(request.getNewEmail());
        var updatedEmployee =employeeRepo.save(employee);

        UpdateEmployeeResponse response = new UpdateEmployeeResponse();
        response.getMESSAGE();
        response.setId(updatedEmployee.getId());
         return  response;
    }
    @Override
    public DeleteEmloyeeResponse deleteEmployee(DeleteEmloyeeRequest request){
        Employee employee = employeeRepo.findEmployeeByFirstName(request.getFirstName());
        employeeRepo.delete(employee);
        DeleteEmloyeeResponse response = new DeleteEmloyeeResponse();
        response.getMESSAGE();
        response.setId(employee.getId());
        return response;
    }
    @Override
    public Employee findEmployeeByName(String name){
        return employeeRepo.findEmployeeByFirstName(name);
    }
}

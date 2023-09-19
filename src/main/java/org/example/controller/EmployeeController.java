package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.data.model.Employee;
import org.example.dto.*;
import org.example.service.EmployeeInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeInterface employeeInterface;
    @PostMapping("/register")
    public ResponseEntity<String>addEmployee(@RequestBody CreateEmployeeRequest request){
        employeeInterface.addEmployee(request);
        return  new ResponseEntity<>("successful", HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<String> updateEmployee(@RequestBody UpdateEmployeeRequest request){
        employeeInterface.updateUployee(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<DeleteEmloyeeResponse> deleteEmployee(@RequestBody DeleteEmloyeeRequest request){
        employeeInterface.deleteEmployee(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("find")
    public ResponseEntity<Employee> findEmployeeByName(@RequestBody String name){
        employeeInterface.findEmployeeByName(name);
        return  new ResponseEntity<>(HttpStatus.FOUND);
    }
}

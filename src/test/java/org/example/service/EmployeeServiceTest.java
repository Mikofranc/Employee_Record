package org.example.service;

import org.example.data.model.Employee;
import org.example.data.repository.EmployeeRepo;
import org.example.dto.CreateEmployeeRequest;
import org.example.dto.DeleteEmloyeeRequest;
import org.example.dto.UpdateEmployeeRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EmployeeServiceTest {
    @Autowired
    private EmployeeInterface employeeInterface;
    @Autowired
    private EmployeeRepo employeeRepo;

    @BeforeEach
    public void clearDatabaseAlways(){
        employeeRepo.deleteAll();
    }


    @Test
        public void testToAddEmployee(){
        CreateEmployeeRequest request = new CreateEmployeeRequest();
        request.setEmail("michealOgbechie@gmail.com");
        request.setLastName("Ayomide");
        request.setFirstName("micheal");
       employeeInterface.addEmployee(request);
        assertEquals(1, employeeRepo.count());
    }
    @Test
    public void testToAdd_MultipleEmployee(){
        CreateEmployeeRequest request = new CreateEmployeeRequest();
        request.setEmail("ay@gmail.com");
        request.setLastName("ay");
        request.setFirstName("francis");
        employeeInterface.addEmployee(request);
        CreateEmployeeRequest request1 = new CreateEmployeeRequest();
        request1.setEmail("john@gmail.com");
        request1.setLastName("john");
        request1.setFirstName("paul");
        employeeInterface.addEmployee(request1);
        assertEquals(3, employeeRepo.count());
    }
    @Test
    public void testToAdd_UpdateEmployee(){
        CreateEmployeeRequest request = new CreateEmployeeRequest();
        request.setEmail("ay@gmail.com");
        request.setLastName("ay");
        request.setFirstName("francis");
        employeeInterface.addEmployee(request);
        CreateEmployeeRequest request1 = new CreateEmployeeRequest();
        request1.setEmail("john@gmail.com");
        request1.setLastName("john");
        request1.setFirstName("paul");
        employeeInterface.addEmployee(request1);

        UpdateEmployeeRequest updateEmployeeRequest = new UpdateEmployeeRequest();
        updateEmployeeRequest.setNewEmail("mmm");
        updateEmployeeRequest.setNewName("paulo");
        updateEmployeeRequest.setNewLastName("ogbech");
        updateEmployeeRequest.setFirstName("paul");
        employeeInterface.updateUployee(updateEmployeeRequest);

        assertEquals(2, employeeRepo.count());
    }
    @Test
    public void deleteAll(){
        employeeRepo.deleteAll();
        assertEquals(0, employeeRepo.count());
    }

    @Test
    public void testToDeleteAnEmployee(){
        CreateEmployeeRequest request = new CreateEmployeeRequest();
        request.setEmail("ay@gmail.com");
        request.setLastName("ay");
        request.setFirstName("francis");
        employeeInterface.addEmployee(request);
        CreateEmployeeRequest request1 = new CreateEmployeeRequest();
        request1.setEmail("john@gmail.com");
        request1.setLastName("john");
        request1.setFirstName("paul");
        employeeInterface.addEmployee(request1);

        DeleteEmloyeeRequest deleteEmloyeeRequest = new DeleteEmloyeeRequest();
        deleteEmloyeeRequest.setFirstName("paul");
        employeeInterface.deleteEmployee(deleteEmloyeeRequest);
        assertEquals(1, employeeRepo.count());
    }


}
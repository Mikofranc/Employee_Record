package org.example.data.repository;

import org.example.data.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    Employee findEmployeeByFirstName(String firstname);
}

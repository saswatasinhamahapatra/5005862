package com.example.employeemanagementsystem.repository;

import com.example.employeemanagementsystem.entity.Employee;
import com.example.employeemanagementsystem.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Derived query method to find employees by name
    List<Employee> findByName(String name);

    // Derived query method to find employees by email
    Optional<Employee> findByEmail(String email);

    // Derived query method to find employees by department
    List<Employee> findByDepartment(Department department);
}

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // Derived query method to find departments by name
    Optional<Department> findByName(String name);
}

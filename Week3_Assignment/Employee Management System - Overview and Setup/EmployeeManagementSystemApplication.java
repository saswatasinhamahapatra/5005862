package com.example.EmployeeManagementSystem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class EmployeeManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementSystemApplication.class, args);
    }

    // Sample data for testing
    @Bean
    CommandLineRunner initData(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        return args -> {
            Department department = new Department();
            department.setName("IT");
            department = departmentRepository.save(department);

            Employee employee = new Employee();
            employee.setFirstName("John");
            employee.setLastName("Doe");
            employee.setEmail("john.doe@example.com");
            employee.setDepartment(department);

            employeeRepository.save(employee);
        };
    }

    // Entity: Employee
    @Data
    @Entity
    @Table(name = "employees")
    public static class Employee {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String firstName;
        private String lastName;
        private String email;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "department_id", nullable = false)
        private Department department;
    }

    // Entity: Department
    @Data
    @Entity
    @Table(name = "departments")
    public static class Department {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;

        @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        private List<Employee> employees;
    }

    // Repository: EmployeeRepository
    @Repository
    public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    }

    // Repository: DepartmentRepository
    @Repository
    public interface DepartmentRepository extends JpaRepository<Department, Long> {
    }

    // Service: EmployeeService
    @Service
    public static class EmployeeService {

        private final EmployeeRepository employeeRepository;

        public EmployeeService(EmployeeRepository employeeRepository) {
            this.employeeRepository = employeeRepository;
        }

        public List<Employee> getAllEmployees() {
            return employeeRepository.findAll();
        }

        public Optional<Employee> getEmployeeById(Long id) {
            return employeeRepository.findById(id);
        }

        public Employee saveEmployee(Employee employee) {
            return employeeRepository.save(employee);
        }

        public void deleteEmployee(Long id) {
            employeeRepository.deleteById(id);
        }
    }

    // Controller: EmployeeController
    @RestController
    @RequestMapping("/api/employees")
    public static class EmployeeController {

        private final EmployeeService employeeService;

        public EmployeeController(EmployeeService employeeService) {
            this.employeeService = employeeService;
        }

        @GetMapping
        public List<Employee> getAllEmployees() {
            return employeeService.getAllEmployees();
        }

        @GetMapping("/{id}")
        public Optional<Employee> getEmployeeById(@PathVariable Long id) {
            return employeeService.getEmployeeById(id);
        }

        @PostMapping
        public Employee createEmployee(@RequestBody Employee employee) {
            return employeeService.saveEmployee(employee);
        }

        @DeleteMapping("/{id}")
        public void deleteEmployee(@PathVariable Long id) {
            employeeService.deleteEmployee(id);
        }
    }
}

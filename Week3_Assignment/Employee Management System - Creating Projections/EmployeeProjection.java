package com.example.employeemanagementsystem.projection;

import com.example.employeemanagementsystem.entity.Department;
import org.springframework.beans.factory.annotation.Value;

public interface EmployeeProjection {

    String getName();

    String getEmail();

    @Value("#{target.department.name}")
    String getDepartmentName();
}

public class EmployeeDto {

    private String name;
    private String email;
    private String departmentName;

    public EmployeeDto(String name, String email, String departmentName) {
        this.name = name;
        this.email = email;
        this.departmentName = departmentName;
    }

    // Getters and Setters
}

package com.exerciseOne.FormValidations.service;

import com.exerciseOne.FormValidations.controller.dto.EmployeeDTO;
import com.exerciseOne.FormValidations.entities.Department;
import com.exerciseOne.FormValidations.entities.Employee;
import com.exerciseOne.FormValidations.persistence.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee saveEmployee(EmployeeDTO employeeDTO){
        Employee employee = Employee.builder()
                .name(employeeDTO.getName())
                .lastName(employeeDTO.getLastName())
                .email(employeeDTO.getEmail())
                .phone(employeeDTO.getPhone())
                .age(employeeDTO.getAge())
                .height(employeeDTO.getHeight())
                .married(employeeDTO.isMarried())
                .dateOfBirth(employeeDTO.getDateOfBirth())
                .department(Department.builder()
                        .name(employeeDTO.getDepartmentDTO().getName())
                        .city(employeeDTO.getDepartmentDTO().getCity())
                        .build())
                .build();
        return this.employeeRepository.save(employee);
    }
}

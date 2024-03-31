package com.exerciseOne.FormValidations.controller;

import com.exerciseOne.FormValidations.controller.dto.EmployeeDTO;
import com.exerciseOne.FormValidations.entities.Employee;
import com.exerciseOne.FormValidations.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/save")
    public ResponseEntity<Employee> saveEmployee(@RequestBody @Valid EmployeeDTO employeeDTO){ //el @Valid lo envía al exceptionHandler que creamos en advice, es para validar en el DTO antes de grabar
        return new ResponseEntity<>(this.employeeService.saveEmployee(employeeDTO), HttpStatus.CREATED);
    }

}

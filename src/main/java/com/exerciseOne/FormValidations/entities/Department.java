package com.exerciseOne.FormValidations.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private String city;

    //Relación uno (un dpto tiene muchos empleados
    @OneToMany(targetEntity = Employee.class, fetch = FetchType.LAZY, mappedBy = "department")
    private List<Employee> employeeList;

}

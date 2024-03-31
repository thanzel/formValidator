package com.exerciseOne.FormValidations.persistence;

import com.exerciseOne.FormValidations.entities.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}

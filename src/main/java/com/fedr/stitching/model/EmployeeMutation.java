package com.fedr.stitching.model;

import com.fedr.stitching.input.EmployeeInput;
import com.fedr.stitching.repository.EmployeeRepository;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;
import org.springframework.beans.factory.annotation.Autowired;

@DgsComponent
public class EmployeeMutation {

    @Autowired
    EmployeeRepository employeeRepository;

    @DgsData(parentType = "MutationResolver",field = "newEmployee")
    public Employee addOrganization(@InputArgument("employee") EmployeeInput employeeInput){
        Employee employee = new Employee();
        employee.setId(employeeInput.getId());
        employee.setFirstName(employeeInput.getFirstName());
        employee.setLastName(employeeInput.getLastName());
        employee.setAge(employeeInput.getAge());
        employee.setSalary(employeeInput.getSalary());
        employee.setPosition(employeeInput.getPosition());
        employee.setOrganizationId(employeeInput.getOrganizationId());
        employeeRepository.save(employee);
        return employee;
    }
}

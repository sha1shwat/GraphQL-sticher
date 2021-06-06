package com.fedr.stitching.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeInput {


    private Integer id;

    private String firstName;

    private String lastName;
    private String position;
    private int salary;
    private int age;
    private String organizationId;
}

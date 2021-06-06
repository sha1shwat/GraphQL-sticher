package com.fedr.stitching.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "worker")
@Getter
@Setter
public class Employee {


    @Id
    private Integer id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    private String position;
    private int salary;
    private int age;
    @Column(name = "organization_id")
    String organizationId;

}

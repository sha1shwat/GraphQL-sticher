package com.fedr.stitching.repository;

import com.fedr.stitching.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee,Integer> {

    Iterable<Employee> findByOrganizationIdIn(Iterable<String> ids);

    @Query("select u from Employee u where u.organizationId in ?1 and u.firstName in ?2")
    Iterable<Employee> findByOrganizationIdAndNames(@Param("1") List<String> ids, @Param("2") List<String> names);
}

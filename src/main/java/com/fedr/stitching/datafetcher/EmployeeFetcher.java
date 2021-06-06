package com.fedr.stitching.datafetcher;

import com.fedr.stitching.filter.EmployeeFilter;
import com.fedr.stitching.model.Employee;
import com.fedr.stitching.repository.EmployeeRepository;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@DgsComponent
@Slf4j
public class EmployeeFetcher {

    @Autowired
    EmployeeRepository employeeRepository;

    @DgsData(parentType = "QueryResolver",field = "allEmployee")
    public List<Employee> findAll(){

        return (List<Employee>) employeeRepository.findAll();
    }

//    @DgsData(parentType = "QueryResolver",field = "allOrganizationUsingFilter")
//    public List<Organization> findAllByFilter(@InputArgument("filter") OrganizationFilter filter){
//
//        return (List<Organization>) organizationRepository.findByEmployeeIdIn(filter.getIds());
//    }

    @DgsData(parentType = "QueryResolver",field = "allEmployeeUsingFilter")
    public List<Employee> findAllByFilter(@InputArgument("filter") EmployeeFilter filter){

       log.info("Organization fetch for ids {}",filter.toString());
        List<Employee> list = new ArrayList<>();
        if (filter.getIds() != null && filter.getNames()!= null) {
            list = (List<Employee>) employeeRepository.findByOrganizationIdAndNames(filter.getIds(), filter.getNames());
        } else if(filter.getIds() !=null){
            list = (List<Employee>) employeeRepository.findByOrganizationIdIn(filter.getIds());
        }

        return  list;
    }


}

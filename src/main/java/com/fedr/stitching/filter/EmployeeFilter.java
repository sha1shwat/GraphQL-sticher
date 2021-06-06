package com.fedr.stitching.filter;

import lombok.Data;

import java.util.List;

@Data
public class EmployeeFilter {

    private List<String> ids;
    private List<String> names;
}

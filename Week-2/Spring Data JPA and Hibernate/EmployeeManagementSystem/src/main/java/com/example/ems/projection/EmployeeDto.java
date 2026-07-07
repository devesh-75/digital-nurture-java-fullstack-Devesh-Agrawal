package com.example.ems.projection;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EmployeeDto {
    private String name;
    private String email;
    private String departmentName;
}

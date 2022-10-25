package com.ashink.graduationdesign.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeInformation {
    private Long id;
    private String userName;
    private String empName;
    private String address;
    private String contact;
    private String sex;
}

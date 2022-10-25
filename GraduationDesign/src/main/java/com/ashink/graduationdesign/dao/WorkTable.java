package com.ashink.graduationdesign.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkTable {
    private Integer id;
    private String userName;
    private String jobTitle;
    private String jobDescription;
    private String superiorNum;
    private Long processingLevel;
}

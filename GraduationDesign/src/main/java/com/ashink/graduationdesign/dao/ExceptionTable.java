package com.ashink.graduationdesign.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionTable {
    private Long id;//自增id
    private String userName;
    private String superiorNum;
    private Timestamp startTime;
    private Timestamp endTime;
    private String isProcessing;
    private String problemType;
    private Long processingLevel;



}

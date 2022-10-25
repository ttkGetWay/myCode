package com.ashink.graduationdesign.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionStatus {
    private Long id;
    private String userName;
    private String superiorNum;
    private Timestamp startTime;
    private Long processingLevel;
    private String processingState;
}

package com.tking.andonsystem.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

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

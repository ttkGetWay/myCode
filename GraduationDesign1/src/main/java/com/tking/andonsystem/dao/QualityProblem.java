package com.tking.andonsystem.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QualityProblem {
    private Long id;
    private String userName;
    private String nameMaterial;
    private String materialNumber;
    private String unitSelect;
    private Timestamp inFormTime;
    private Long questionNumber;
    private String reasonDescription;
}

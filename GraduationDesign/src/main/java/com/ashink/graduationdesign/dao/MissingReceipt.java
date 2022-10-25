package com.ashink.graduationdesign.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * 缺料回执
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissingReceipt {
    private Long id;
    private String userName;
    private String materialName;
    private String materialNumber;
    private String specifications;
    private String unit;
    private Long needNumber;
    private Timestamp inFormTime;
}

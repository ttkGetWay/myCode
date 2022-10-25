package com.ashink.graduationdesign.dao;

import javafx.scene.control.CheckBox;
import lombok.Data;

@Data
public class LogTableModel {
    private CheckBox checkBox;
    private Integer id;//自增id
    private String userName;
    private String superiorNum;
    private String startTime;
    private String endTime;
    private String isProcessing;
    private String problemType;
    private Integer processingLevel;
}

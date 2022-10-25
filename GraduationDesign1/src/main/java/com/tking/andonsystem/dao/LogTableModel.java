package com.tking.andonsystem.dao;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
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

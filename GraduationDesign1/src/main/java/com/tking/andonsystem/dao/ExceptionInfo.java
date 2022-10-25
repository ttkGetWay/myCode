package com.tking.andonsystem.dao;

import cn.hutool.core.date.DateUtil;
import com.tking.andonsystem.util.DateTool;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Date;

public class ExceptionInfo {
    private SimpleBooleanProperty isSelected = new SimpleBooleanProperty();
    private SimpleLongProperty id = new SimpleLongProperty();//自增id
    private SimpleStringProperty userName = new SimpleStringProperty();
    private SimpleStringProperty superiorNum = new SimpleStringProperty();
    private SimpleStringProperty startTime = new SimpleStringProperty();
    private SimpleStringProperty endTime = new SimpleStringProperty();
    private SimpleStringProperty isProcessing = new SimpleStringProperty();
    private SimpleStringProperty problemType = new SimpleStringProperty();
    private SimpleLongProperty processingLevel = new SimpleLongProperty();

    public ExceptionInfo(ExceptionTable exceptionTable, boolean isSelected) {
        if (exceptionTable != null) {
            this.id.set(exceptionTable.getId());
            this.userName.set(exceptionTable.getUserName());
            this.superiorNum.set(exceptionTable.getSuperiorNum());
            this.startTime.set(DateUtil.formatDateTime(exceptionTable.getStartTime()));
            if (exceptionTable.getEndTime() == null){
                this.endTime.set("");
            }else{
                this.endTime.set(DateUtil.formatDateTime(exceptionTable.getEndTime()));
            }
            this.isProcessing.set(exceptionTable.getIsProcessing());
            this.id.set(exceptionTable.getId());
            this.problemType.set(exceptionTable.getProblemType());
            this.processingLevel.set(exceptionTable.getProcessingLevel());
            this.isSelected.set(isSelected);
        }
    }

    public boolean isIsSelected() {
        return isSelected.get();
    }

    public SimpleBooleanProperty getIsSelectedProperty() {
        return isSelected;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected.set(isSelected);
    }

    public boolean getIsSelected(){
        return isSelected.get();
    }

    public long getId() {
        return id.get();
    }

    public SimpleLongProperty getIdProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getUserName() {
        return userName.get();
    }

    public SimpleStringProperty getUserNameProperty() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName.set(userName);
    }

    public String getSuperiorNum() {
        return superiorNum.get();
    }

    public SimpleStringProperty getSuperiorNumProperty() {
        return superiorNum;
    }

    public void setSuperiorNum(String superiorNum) {
        this.superiorNum.set(superiorNum);
    }

    public String getStartTime() {
        return startTime.get();
    }

    public SimpleStringProperty getStartTimeProperty() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime.set(startTime);
    }

    public String getEndTime() {
        return endTime.get();
    }

    public SimpleStringProperty getEndTimeProperty() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime.set(endTime);
    }

    public String getIsProcessing() {
        return isProcessing.get();
    }

    public SimpleStringProperty getIsProcessingProperty() {
        return isProcessing;
    }

    public void setIsProcessing(String isProcessing) {
        this.isProcessing.set(isProcessing);
    }

    public String getProblemType() {
        return problemType.get();
    }

    public SimpleStringProperty getProblemTypeProperty() {
        return problemType;
    }

    public void setProblemType(String problemType) {
        this.problemType.set(problemType);
    }

    public long getProcessingLevel() {
        return processingLevel.get();
    }

    public SimpleLongProperty getProcessingLevelProperty() {
        return processingLevel;
    }

    public void setProcessingLevel(int processingLevel) {
        this.processingLevel.set(processingLevel);
    }

    @Override
    public String toString() {
        return "ExceptionInfo{" +
                "isSelected=" + isSelected +
                ", id=" + id +
                ", userName=" + userName +
                ", superiorNum=" + superiorNum +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", isProcessing=" + isProcessing +
                ", problemType=" + problemType +
                ", processingLevel=" + processingLevel +
                '}';
    }
}


package com.ashink.graduationdesign.dao;

import javafx.beans.property.SimpleStringProperty;

import java.sql.Timestamp;

public class InformData {
    private SimpleStringProperty userName = new SimpleStringProperty();
    private SimpleStringProperty empName = new SimpleStringProperty();
    private SimpleStringProperty startTime = new SimpleStringProperty();
    private SimpleStringProperty eventDescription = new SimpleStringProperty();
    private Timestamp timestamp;
    private String superiorNum;

    public InformData(String superiorNum, Timestamp timestamp, String userName,
                      String empName,
                      String startTime,
                      String eventDescription) {
        this.superiorNum = superiorNum;
        this.timestamp = timestamp;
        this.userName.set(userName);
        this.empName.set(empName);
        this.startTime.set(startTime);
        this.eventDescription.set(eventDescription);
    }

    public String getSuperiorNum() {
        return superiorNum;
    }

    public void setSuperiorNum(String superiorNum) {
        this.superiorNum = superiorNum;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getUserName() {
        return userName.get();
    }

    public SimpleStringProperty getUserNameProperty() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName.set(userName);
    }

    public String getEmpName() {
        return empName.get();
    }

    public SimpleStringProperty getEmpNameProperty() {
        return this.empName;
    }

    public void setEmpName(String empName) {
        this.empName.set(empName);
    }

    public String getStartTime() {
        return startTime.get();
    }

    public SimpleStringProperty getStartTimeProperty() {
        return this.startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime.set(startTime);
    }

    public String getEventDescription() {
        return eventDescription.get();
    }

    public SimpleStringProperty getEventDescriptionProperty() {
        return this.eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription.set(eventDescription);
    }
}

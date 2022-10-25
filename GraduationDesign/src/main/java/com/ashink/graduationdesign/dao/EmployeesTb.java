package com.ashink.graduationdesign.dao;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class EmployeesTb {
    private SimpleBooleanProperty isSelected = new SimpleBooleanProperty();
    private SimpleLongProperty id = new SimpleLongProperty();//自增id
    private SimpleStringProperty userName = new SimpleStringProperty();
    private SimpleStringProperty empName = new SimpleStringProperty();
    private SimpleStringProperty address = new SimpleStringProperty();
    private SimpleStringProperty contact = new SimpleStringProperty();
    private SimpleStringProperty sex = new SimpleStringProperty();

    public EmployeesTb(EmployeeInformation employeeInformation, boolean isSelected) {
        if (employeeInformation != null) {
            this.id.set(employeeInformation.getId());
            this.userName.set(employeeInformation.getUserName());
            this.empName.set(employeeInformation.getEmpName());
            this.address.set(employeeInformation.getAddress());
            this.contact.set(employeeInformation.getContact());
            this.sex.set(employeeInformation.getSex());
            this.isSelected.set(isSelected);
        }
    }

    public boolean isIsSelected() {
        return isSelected.get();
    }

    public SimpleBooleanProperty isSelectedProperty() {
        return isSelected;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected.set(isSelected);
    }

    public long getId() {
        return id.get();
    }

    public SimpleLongProperty idProperty() {
        return id;
    }

    public void setId(long id) {
        this.id.set(id);
    }

    public String getUserName() {
        return userName.get();
    }

    public SimpleStringProperty userNameProperty() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName.set(userName);
    }

    public String getEmpName() {
        return empName.get();
    }

    public SimpleStringProperty empNameProperty() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName.set(empName);
    }

    public String getAddress() {
        return address.get();
    }

    public SimpleStringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public String getContact() {
        return contact.get();
    }

    public SimpleStringProperty contactProperty() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact.set(contact);
    }

    public String getSex() {
        return sex.get();
    }

    public SimpleStringProperty sexProperty() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex.set(sex);
    }
}

package com.ashink.graduationdesign.controller;

import com.ashink.graduationdesign.dao.*;
import com.ashink.graduationdesign.mapper.UserMapper;
import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Data
@RestController
public class UserController {
    private long time;
    private int count = 0;
    private long mark = 0;
    private List<Date> dateList;
    ObservableList<InformData> empObservableList;
    ObservableList<InformData> adminObservableList;
    private Timestamp date;
    private String userName;
    private Integer commandType;
    private ListView<InformData> listView;
    private ListView<InformData> empListView;
    private InformData informData1;
    private ListCell<InformData> listCell;
    private List<ExceptionTable> exceptionTables;

    private List<ExceptionTable> adminExceptionTables;

    private long admin = 0;
    private long emp = 0;

    //    private InformData informData1;
    private InformData informData2;

    @Autowired
    private UserMapper userMapper;

    public AccountStatus queryAccountStatus(String userName) {
        AccountStatus accountStatus = userMapper.queryAccountStatus(userName);
        return accountStatus;
    }

    public User selectByUserNameAndPassword(String userName, String userPassword) {
        User user = userMapper.selectByUserNameAndPassword(userName, userPassword);
        return user;
    }

    public String addStatus(AccountStatus accountStatus) {
        int accountStatus1 = userMapper.addStatus(accountStatus);
        return "success";
    }

    public String deleteStatus(String userName) {
        userMapper.deleteStatus(userName);
        return "success";
    }


    public ExceptionTable exceptionTableMethod(String userName) {
        ExceptionTable exceptionTable = userMapper.exceptionTableMethod(userName);
        return exceptionTable;
    }

    //将异常操作数据插入数据库

    public String addExceptionTable(ExceptionTable exceptionTable) {
        int exceptionTable1 = userMapper.addExceptionTable(exceptionTable);
        return "success";
    }

    public WorkTable queryEmployeesSuperior(String userName) {
        WorkTable workTable = userMapper.queryEmployeesSuperior(userName);
        return workTable;

    }

    public List<ExceptionTable> queryExceptionTableList() {
        List<ExceptionTable> exceptionTables = userMapper.queryExceptionTableList();
        return exceptionTables;
    }


    public EmployeeInformation QueryEmpName(String userName) {
        EmployeeInformation employeeInformation = userMapper.QueryEmpName(userName);
        return employeeInformation;
    }


    public List<ExceptionTable> queryLatestException() {
        List<ExceptionTable> exceptionTable = userMapper.queryLatestException();
        return exceptionTable;
    }

    public String addExceptionStatus(ExceptionStatus exceptionStatus) {
        userMapper.addExceptionStatus(exceptionStatus);
        return "success";
    }


    public ExceptionStatus queryExceptionStatus(String userName, Timestamp startTime) {
        ExceptionStatus exceptionStatus = userMapper.queryExceptionStatus(userName, startTime);
        return exceptionStatus;
    }

    public String updateStatus(String userName, Timestamp startTime, Long processingLevel, String superiorNum2) {
        userMapper.updateStatus(userName, startTime, processingLevel, superiorNum2);
        return "success";
    }

    public String updateStatus2(String userName, Timestamp startTime, String processingState) {
        userMapper.updateStatusTwo(userName, startTime, processingState);

        return "success";
    }


    public List<ExceptionTable> queryExceptionAll(String userName) {
        List<ExceptionTable> exceptionTables = userMapper.queryExceptionAll(userName);
        return exceptionTables;
    }

    public ExceptionStatus latestQueryState(String superiorNum) {
        ExceptionStatus exceptionStatus = userMapper.latestQueryState(superiorNum);
        return exceptionStatus;
    }


    public WorkTable queryProcessingLevel(String userName) {
        WorkTable workTable = userMapper.queryProcessingLevel(userName);
        return workTable;
    }


    public String updateHandleExceptions(String userName,
                                         Timestamp startTime,
                                         String superiorNum,
                                         Timestamp endTime,
                                         String isProcessing,
                                         Long processingLevel) {
        userMapper.updateHandleExceptions(userName, startTime, superiorNum, endTime, isProcessing, processingLevel);
        return "success";
    }

    public String updateStatus3(String userName, String superiorNum, Timestamp startTime, Long processingLevel, String processingState) {
        userMapper.updateStatusThree(userName, superiorNum, startTime, processingLevel, processingState);
        return "success";
    }


    public String addAnnouncement(Announcement accountStatus) {
        userMapper.addAnnouncement(accountStatus);
        return "success";
    }

    public Announcement queryLatestAnnouncements() {
        Announcement announcement = userMapper.queryLatestAnnouncements();
        return announcement;
    }

    public List<EmployeeInformation> queryAllEmployee() {

        List<EmployeeInformation> employeeAll = userMapper.queryAllEmployee();
        return employeeAll;
    }

    public List<InventoryTable> queryWarehouse() {
        List<InventoryTable> inventoryTable = userMapper.queryWarehouse();
        return inventoryTable;
    }

    public String addAllMissingReceipt(MissingReceipt missingReceipt) {
        userMapper.addAllMissingReceipt(missingReceipt);
        return "success";
    }

    public String addQualityProblem(QualityProblem qualityProblem) {
        userMapper.addQualityProblem(qualityProblem);
        return "success";
    }
}

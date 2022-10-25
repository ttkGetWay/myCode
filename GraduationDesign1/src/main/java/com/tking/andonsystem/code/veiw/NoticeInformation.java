package com.tking.andonsystem.code.veiw;

import com.tking.andonsystem.bean.SpringContextUtil;
import com.tking.andonsystem.controllor.UserController;
import com.tking.andonsystem.dao.ExceptionStatus;
import com.tking.andonsystem.dao.InformData;
import com.tking.andonsystem.dao.WorkTable;
import com.tking.andonsystem.util.DateTool;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
public class NoticeInformation extends Pane {

    private InformData informData;
    private Label userAccountName;
    private Label noticeEmpName;
    private Label startTime;
    private Label eventDescription;
    private Button acceptPenalty;
    private Timestamp timestamp;
    private ExceptionStatus exceptionStatus;
    private UserController userController;


    public NoticeInformation(InformData informData) {
        this.informData = informData;
        this.timestamp = informData.getTimestamp();
        userController = SpringContextUtil.getBean(UserController.class);
        queryData();
        init();
        businessProcessing();
        listener();
    }

    private void businessProcessing() {
        if (exceptionStatus != null) {
            if ("已处理".equals(exceptionStatus.getProcessingState())) {


                userAccountName.setText(informData.getUserName());
                noticeEmpName.setText(informData.getEmpName());
                startTime.setText(informData.getStartTime());
                eventDescription.setText(informData.getEventDescription());
                acceptPenalty.setText(exceptionStatus.getProcessingState());
                acceptPenalty.setDisable(true);
            } else if ("等待处理".equals(exceptionStatus.getProcessingState())) {
                userAccountName.setText(informData.getUserName());
                noticeEmpName.setText(informData.getEmpName());
                startTime.setText(informData.getStartTime());
                eventDescription.setText(informData.getEventDescription());
                acceptPenalty.setText(exceptionStatus.getProcessingState());
            } else {
                userAccountName.setText(informData.getUserName());
                noticeEmpName.setText(informData.getEmpName());
                startTime.setText(informData.getStartTime());
                eventDescription.setText(informData.getEventDescription());
                acceptPenalty.setText(exceptionStatus.getProcessingState().substring(0,2));
                acceptPenalty.setDisable(true);
            }
        }
    }


    private void init() {
        userAccountName = new Label("");
        userAccountName.setPrefWidth(80);
        userAccountName.setPrefHeight(30);
        userAccountName.setLayoutX(5);
        userAccountName.setLayoutY(5);

        noticeEmpName = new Label("");
        noticeEmpName.setPrefWidth(50);
        noticeEmpName.setPrefHeight(20);
        noticeEmpName.setLayoutX(10);
        noticeEmpName.setLayoutY(35);

        startTime = new Label("");
        startTime.setPrefWidth(200);
        startTime.setPrefHeight(20);
        startTime.setLayoutX(980);
        startTime.setLayoutY(10);

        eventDescription = new Label("");
        eventDescription.setPrefWidth(120);
        eventDescription.setPrefHeight(20);
        eventDescription.setLayoutX(70);
        eventDescription.setLayoutY(35);

        acceptPenalty = new Button("");
        acceptPenalty.setPrefWidth(80);
        acceptPenalty.setPrefHeight(30);
        acceptPenalty.setLayoutX(1060);
//        acceptPenalty.setLayoutX(225);
        acceptPenalty.setLayoutY(35);
        setPrefWidth(350);
        setPrefHeight(80);
        getChildren().addAll(userAccountName, noticeEmpName,
                startTime, eventDescription, acceptPenalty);
    }

    private void queryData() {
        exceptionStatus = userController.queryExceptionStatus(informData.getUserName(), timestamp);
    }

    private void doAnyThing() {
    }

    private void listener() {
        NoticeInformation noticeInformation = this;
        acceptPenalty.setOnAction(event -> {
            acceptPenalty.setText("已处理");
            WorkTable workTable = userController.queryProcessingLevel(informData.getSuperiorNum());
            Long processingLevel = workTable.getProcessingLevel();
            System.out.println(processingLevel);
            userController.updateHandleExceptions(informData.getUserName(), timestamp, informData.getSuperiorNum(), DateTool.dateNow(), "是", processingLevel);
            System.out.println(timestamp);
            userController.updateStatus3(informData.getUserName(),informData.getSuperiorNum(), timestamp, processingLevel, "已处理");
            acceptPenalty.setDisable(true);
        });


    }
}

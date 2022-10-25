package com.tking.andonsystem.code.viewinterface;

import java.util.Date;

public interface EmployeesInFace {
    void doSendMsg(String userId, String talkId, Integer talkType, String msg, Integer msgType, Date msgDate);

    void showPersonal(String userName);

    void qualitySubmit();





}

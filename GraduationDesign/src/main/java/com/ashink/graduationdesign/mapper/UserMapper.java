package com.ashink.graduationdesign.mapper;

import com.ashink.graduationdesign.dao.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 * 操作数据库
 * 这是一个mybatis的mapper类
 */
@Mapper
@Repository
public interface UserMapper {
    //查询所有用户
    List<User> queryUserList();

    //查询用户状态
    AccountStatus queryAccountStatus(String userName);

    //账户密码
    User selectByUserNameAndPassword(@Param("userName") String userName, @Param("userPassword") String userPassword);

    //
    int addStatus(AccountStatus accountStatus);

    //
    int deleteStatus(String userName);

    //查询异常表中是否有数据
    ExceptionTable exceptionTableMethod(String userName);

    //将数据插入异常数据表
    int addExceptionTable(ExceptionTable exceptionTable);

    WorkTable queryEmployeesSuperior(String userName);

    List<ExceptionTable> queryExceptionTableList();

    EmployeeInformation QueryEmpName(String userName);

    List<ExceptionTable> queryLatestException();

    int addExceptionStatus(ExceptionStatus exceptionStatus);

    ExceptionStatus queryExceptionStatus(@Param("userName") String userName,
                                         @Param("startTime") Timestamp startTime);

    int updateStatus(@Param("userName") String userName,
                     @Param("startTime") Timestamp startTime,
                     @Param("processingLevel") Long processingLevel,
                     @Param("superiorNum") String superiorNum);

    int updateStatusTwo(@Param("userName") String userName,
                        @Param("startTime") Timestamp startTime,
                        @Param("processingState") String processingState);

    List<ExceptionTable> queryExceptionAll(String userName);

    ExceptionStatus latestQueryState(String superiorNum);

    WorkTable queryProcessingLevel(String userName);

    int updateHandleExceptions(@Param("userName") String userName,
                               @Param("startTime") Timestamp startTime,
                               @Param("superiorNum") String superiorNum,
                               @Param("endTime") Timestamp endTime,
                               @Param("isProcessing") String isProcessing,
                               @Param("processingLevel") Long processingLevel);

    int updateStatusThree(@Param("userName") String userName,
                          @Param("superiorNum") String superiorNum,
                          @Param("startTime") Timestamp startTime,
                          @Param("processingLevel") Long processingLevel,
                          @Param("processingState") String processingState);

    int addAnnouncement(Announcement accountStatus);

    Announcement queryLatestAnnouncements();

    List<EmployeeInformation> queryAllEmployee();

    List<InventoryTable> queryWarehouse();

    int addAllMissingReceipt(MissingReceipt missingReceipt);

    int addQualityProblem(QualityProblem qualityProblem);
}

package com.ashink.graduationdesign.quartz;//package com.tking.andonsystem.quartz;
//
//import cn.hutool.core.date.DateUtil;
//import com.tking.andonsystem.bean.SpringContextUtil;
//import com.tking.andonsystem.code.veiw.NoticeInformation;
//import com.tking.andonsystem.controllor.UserController;
//import com.tking.andonsystem.controllor.viewcontroller.ControllerImpl;
//import com.tking.andonsystem.dao.ExceptionStatus;
//import com.tking.andonsystem.dao.ExceptionTable;
//import com.tking.andonsystem.dao.InformData;
//import com.tking.andonsystem.util.DateTool;
//import javafx.application.Platform;
//import javafx.collections.ObservableList;
//import javafx.scene.control.ListCell;
//import javafx.scene.control.ListView;
//import javafx.util.Callback;
//import lombok.Data;
//import lombok.extern.slf4j.Slf4j;
//import org.quartz.Job;
//import org.quartz.JobExecutionContext;
//import org.quartz.JobExecutionException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//import java.util.List;
//
//
//@Slf4j
//@Data
//@Component
//public class QuartzJob implements Job {
//    private String userName;
//    private Integer commandType;
//    private long count;
//
//
//    private String superiorNum = null;
//    private String superiorNum2 = null;
//
//
//    @Autowired
//    private UserController userController;
//    private ControllerImpl controllerBean;
//
//
//    int listPre = 0;
//
//    @Override
//    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
//        userController = SpringContextUtil.getBean(UserController.class);
//        userName = userController.getUserName();
//        if (userName != null) {
//            if (userName.contains("admin")) {
//                List<ExceptionTable> exceptionTables = userController.queryExceptionTableList();
//                if (exceptionTables.size() != 0) {
////                    System.out.println("exceptionTables"+exceptionTables);
////                    System.out.println("quartz----->" + userController);
////                    userController.setAdminExceptionTables(exceptionTables);
//                    Platform.runLater(new Runnable() {
//                        @Override
//                        public void run() {
//                            //更新JavaFX的主线程的代码放在此处
//
//                            userController.setExceptionTables(userController.queryLatestException());
//                            String userAccName;
//                            String empName;
//                            Date startTime;
//                            String problemType;
//
//                            listPre = userController.getExceptionTables().size();
//                            if (userController.getExceptionTables().size() != 0) {
//
//
//
//                                for (ExceptionTable exceptionTable:userController.getExceptionTables()) {
//                                    userAccName = exceptionTable.getUserName();
//                                    empName = userController.QueryEmpName(userAccName).getEmpName();
//                                    startTime = exceptionTable.getStartTime();
//                                    problemType = exceptionTable.getProblemType();
//
//
//
//                                    userController.setInformData1(new InformData(userAccName, empName, DateUtil.formatDateTime(startTime), problemType));
//                                    adminView();
//                                }
//
////                                if (userController.getAdmin() == 0) {
////                                    userController.setAdminObservableList(userController.getListView().getItems());
////                                    userController.setAdmin(1);
////                                }
////                                System.out.println(userController.getAdmin());
////                                if (userController.getDateList().size() == 0) {
////                                    System.out.println("----->" + startTime);
////                                    userController.getDateList().add(startTime);
////
////                                    adminView();
////                                    System.out.println("---1111111111111---");
////                                } else if (startTime.equals(userController.getDateList().get(userController.getCount()))) {
////                                    System.out.println(startTime.equals(userController.getDateList().get(userController.getCount())));
////                                    System.out.println("---222222222222---");
////                                } else if (!startTime.equals(userController.getDateList().get(userController.getCount()))) {
////                                    userController.setInformData1(new InformData(userAccName, empName, DateUtil.formatDateTime(startTime), problemType));
////                                    adminView();
////                                    System.out.println("------3333333333333---");
////                                    userController.getDateList().add(startTime);
////                                    userController.setCount(userController.getCount() + 1);
////                                }
//                            }
//
//
//                        }
//                    });
//                }
//            } else if (userName.contains("sta")) {
//                System.out.println(userController.getTime());
//                commandType = userController.getCommandType();
//                if (commandType != null) {
//                    switch (commandType) {
//                        case 1:
//                            userController.setTime(userController.getTime() + 2);
//                            if (userController.getTime() <= 30 && userController.getTime() >= 0) {
//                                superiorNum = userController.queryEmployeesSuperior(userName).getSuperiorNum();
//                                if (userController.getTime() == 2) {
//                                    userController.addExceptionTable(new ExceptionTable(0,
//                                            userName, null, userController.getDate(),
//                                            null, null, "缺料", 1));
//                                    userController.addExceptionStatus(new ExceptionStatus(0, userName, superiorNum, userController.getDate(), 1, "等待处理"));
//                                }
//                                ExceptionStatus exceptionStatus = null;
//                                if (userController.getDate() != null) {
//                                    exceptionStatus = userController.queryExceptionStatus(userName, userController.getDate());
//                                }
//                                if (exceptionStatus != null) {
//                                    if ("已受理".equals(exceptionStatus.getProcessingState())) {
//                                        userController.setTime(0);
//
//                                    } else {
//                                        log.info("异常等待处理中....");
//                                    }
//                                }
//
//                            }
//                            if (userController.getTime() >= 30 && userController.getTime() <= 60) {
//                                if (userController.getTime() == 32) {
//                                    userController.updateStatus(userName, userController.getDate(), 2);
//                                }
//                                if (superiorNum != null && userController.getDate() != null)
//                                    superiorNum2 = userController.queryEmployeesSuperior(superiorNum).getSuperiorNum();
//
//                                ExceptionStatus exceptionStatus = userController.queryExceptionStatus(userName, userController.getDate());
//                                if (exceptionStatus != null) {
//                                    if ("已受理".equals(exceptionStatus.getProcessingState())) {
//                                        userController.setTime(0);
//                                    } else {
//                                        log.info("异常等待处理中....");
//                                    }
//                                }
//                            }
//                            log.info(userName + "进行了取料呼叫操作");
//
//                            break;
//                        case 2:
//                            if (userController.getTime() == 2) {
//                                userController.addExceptionTable(new ExceptionTable(0,
//                                        userName, null, DateTool.dateNow(),
//                                        null, null, "质量", 1));
//                            }
//                            log.info(userName + "进行了质量呼叫操作");
//                            break;
//                        case 3:
//                            log.info(userName + "进行了呼叫操作");
//                            break;
//                        case 4:
//                            if (userController.getTime() == 2) {
//                                userController.addExceptionTable(new ExceptionTable(0,
//                                        userName, null, DateTool.dateNow(),
//                                        null, null, "设备", 1));
//                            }
//                            log.info(userName + "进行了设备呼叫呼叫操作");
//                            break;
//                    }
//
//                } else {
//                    log.info("没有任何操作" + DateUtil.formatDateTime(DateTool.dateNow()));
//                }
//                Platform.runLater(() -> {
//                    if (userController.getCommandType() != null && userController.getCommandType().equals(8)) {
//                        userController.setTime(userController.getTime() + 2);
//                        userController.setInformData2(new InformData("", "", DateUtil.formatDateTime(com.tking.andonsystem.util.DateTool.dateNow()), "质量"));
//
//                        userController.getEmpObservableList().add(userController.getInformData2());
//                        userController.getEmpListView().setCellFactory(new Callback<ListView<InformData>, ListCell<InformData>>() {
//                            @Override
//                            public ListCell<InformData> call(ListView<InformData> param) {
//                                ListCell<InformData> listCell = new ListCell<InformData>() {
//                                    @Override
//                                    protected void updateItem(InformData item, boolean empty) {
//                                        super.updateItem(item, empty);
//                                        if (empty || item == null) {
//                                            this.setText(null);
//                                            this.setGraphic(null);
//                                        } else {
//                                            if (userController.getInformData2() != null) {
//                                                NoticeInformation noticeInfoPane = new NoticeInformation(userController.getInformData2());
//                                                this.setGraphic(noticeInfoPane);
//                                            }
//
//                                        }
//                                    }
//                                };
//                                return listCell;
//                            }
//                        });
//                    }
//                });
//            }
//        }
//    }
//
//
//
////    public void empView() {
////
////    }
//
//
//
//
//    private void adminView() {
//        userController.getAdminObservableList().add(userController.getInformData1());
//        userController.getListView().getItems().addAll(userController.getInformData1());
//        userController.getListView().setCellFactory(new Callback<ListView<InformData>, ListCell<InformData>>() {
//            @Override
//            public ListCell<InformData> call(ListView<InformData> param) {
//                ListCell<InformData> listCell = new ListCell<InformData>() {
//                    @Override
//                    protected void updateItem(InformData item, boolean empty) {
//                        super.updateItem(item, empty);
//                        if (empty || item == null) {
//                            this.setText(null);
//                            this.setGraphic(null);
//                        } else {
//                            if (userController.getInformData1() != null) {
//                                System.out.println("----4444444444444----");
//                                NoticeInformation noticeInfoPane = new NoticeInformation(userController.getInformData1());
//                                this.setGraphic(noticeInfoPane);
//                            }
//                        }
//                    }
//                };
//                return listCell;
//            }
//        });
//    }
//}
//
//

package com.ashink.graduationdesign.controller;

import com.ashink.graduationdesign.dao.*;
import com.ashink.graduationdesign.em.CommandType;
import com.ashink.graduationdesign.util.DateTool;
import com.ashink.graduationdesign.util.SpringContextUtil;
import com.ashink.graduationdesign.util.Tools;
import com.ashink.graduationdesign.view.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.util.Callback;
import javafx.util.Duration;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @TotalControl 一个总的控制层
 */
@Data
@Slf4j
public class ControllerImpl {
    private List<Date> dateList;
    private long time = 0;
    private long count = 0;
    private long mark = 0;
    private long markTwo = 0;
    private long query = 0;
    private long emp = 0;
    private UserController userController;

    private List<Timestamp> timestampList = new ArrayList<>();

    private AdminView adminView;
    private EmployeesView employeesView;
    private LoginView loginView;
    private LogPane logPane;
    private ReleasePane releasePane;
    private UserPane userPane;
    private TextField field;
    private PasswordField passwordField;
    private Button loginButton;
    private Pane loginPane;
    private LackMaterialPane lackMatePane;
    private QualityPane qualityPane;
    private ScramPane scramPane;
    private MessageDialog messageDialog;


    /**
     * admin界面的功能变量
     */
    private Pane backGroundPane, searchPane;
    private TextField searchField;
    private Label loginTitle, dialogTitle;
    private Pane messagePane, editPane, usersPane, logsPane, rightInteractional, filePane, picturePane;
    private TextArea chatInputField;
    private Button sandButton;
    private ListView<InformData> messageList;
    private InformData informData1;
    private ListCell<InformData> listCell;
    private TableView<ExceptionInfo> logTableView;
    private TableView<EmployeesTb> userTableView;
    private ListView<InformData> messageListP;
    private Button removeStyle, releaseNowButton;
    private TextField titleFiled, sanderFiled;
    private TextArea contentFiled;
    private ListView<String> publishedList;

    /**
     * 标志变量定位使用
     */
    private Pane positioning;
    private Pane positioningEmp;

    /**
     * @userP 用户管理功能相关变量
     * @Pane 公告发布功能变量
     * @logP 日志管理功能变量
     */
    private Pane userP, releaseP, logP;


    private String userName;
    private String passWord;
    private String toCompare;
    private String superiorNum;


    /**
     * 员工操作界面相关变量，初始界面有的内容
     *
     * @empPane 员工界面主体
     * @bottomPane 界面切换主体
     * @blueButton, yellowButton, greenButton, redButton 相应的异常事件
     * @emlLoginTitle 登录标题名称
     * @mainBodyPane 主体中的底层
     * @floatMessage 主题中的浮动层按钮
     * @redPoint 红点当有消息发来时变红色
     * @locationNum 工位号
     * @workNum 工作号
     * @empName 员工姓名
     */
    private Pane empPane, bottomPane, mainBodyPane;
    private Button blueButton, yellowButton, greenButton, redButton;
    private Label emlLoginTitle;
    private StackPane floatMessage;
    private Circle redPoint;
    private Button locationNum, workNum, empName;

    /**
     * 缺料功能的相关属性
     */
    private Pane materialPane;//外层布局
    private TextField materialName, materialNub, materialTyp, locationNumber;
    private ComboBox<String> unitSelect;
    private ComboBox<String> nameMaterial;
    private ComboBox<String> materialNumber;
    private ComboBox<String> specifications;
    private ComboBox<Long> InventoryQuantity;
    private TextField needNumber;
    private Button submitButton;

    private ComboBox<String> nameMaterialP;
    private ComboBox<String> materialNumberP;
    private ComboBox<String> specificationsP;
    private ComboBox<String> unitSelectP;
    private TextField numProblemsP;
    private TextField reasonDescriptionP;


    /**
     * 质量功能相关属性
     *
     * @partsPane 外层布局
     * @partName 部件名称
     * @partNumber 部件编号
     * @partQuantity 数量单位
     * @submitForm 提交表单
     * @unitComBox 提交按钮
     * @laborStation 工位号
     */
    private Pane partsPane;//外层布局
    private TextField partName, partNumber, partQuantity, laborStation;//
    private Button submitForm;//提交表单
    private ComboBox<String> unitComBox;


    /**
     * 消息对话框界面相关属性变量
     *
     * @mesDiaBox 消息主体
     * @fieldP 文件按钮
     * @pictureP 图片按钮
     * @chatsTitle 聊天对象名称
     * @diaMessage 消息主体
     * @inputArea 输入框
     * @sentButton 发送啊啊牛
     */
    private Pane mesDiaBox;
    private ListView<InformData> diaMessage;


    private ExceptionInfo exceptionInfo;
    private ExceptionInfo exceptionInfo1;
    private ExceptionInfo exceptionInfo2;


    private List<ExceptionTable> exceptionTables;
    private List<EmployeeInformation> employeesTbList;
    private List<ExceptionTable> exceptionTablesMessage;
    private List<ExceptionTable> exceptionTableListEmp;
    private List<InventoryTable> inventoryTables;
    private Announcement announcement;
    private List<Announcement> announcementList = new ArrayList<>();
    private Dialog<ButtonType> stringDialog;
    private ObservableList<ExceptionInfo> logsList;

    private ObservableList<EmployeesTb> userList;


    private InformData informData;

    private ObservableList<InformData> empObservableList;
    private ObservableList<InformData> adminObservableList;
    private ObservableList<InformData> observableList;
    private ObservableList<InformData> observableList2;
    private List<InformData> informDataList;

    private String userAccName;
    private String emName;
    @JsonFormat
    private Timestamp startTime;
    private String problemType;

    private int nowSize;
    private int afterSize;

    private ListView<InformData> floatLitView;


    private String superiorNum2;

    private String title;
    private String sander;
    private String sandTime;
    private String content;
    private Timestamp nowTime;


    private String needNub;
    private String problemsNumber;
    private String cause;


    /**
     * 对界面加载初始化
     */
    public ControllerImpl() {
        loginView = new LoginView();
        adminView = new AdminView();
        employeesView = new EmployeesView();
        logPane = new LogPane();
        releasePane = new ReleasePane();
        userPane = new UserPane();

        lackMatePane = new LackMaterialPane();
        qualityPane = new QualityPane();
        messageDialog = new MessageDialog();


    }

    public Object selector(ParentWindow window, String id) {
        return window.getRoot().lookup("#" + id);
    }

    public Object selector(ParentPane pane, String id) {
        return pane.getRoot().lookup("#" + id);
    }

    /**
     * 登录界面的初始化以及相应的变量初始化
     */
    public void initLogin() {
        loginView.show();
        loginPane = (Pane) selector(loginView, "loginPane");
        field = (TextField) selector(loginView, "userNameField");
        field.setFocusTraversable(true);
        passwordField = ((PasswordField) selector(loginView, "passWordField"));
        passwordField.setFocusTraversable(true);
        loginButton = (Button) selector(loginView, "loginButton");

        loginEventListeners();
    }

    private void loginEventListeners() {
        loginPane.setOnMouseClicked(event -> loginPane.requestFocus());

        loginButton.setOnMouseClicked(event -> loginAuthentication());
        passwordField.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                loginAuthentication();
            }
        });
    }

    private void loginAuthentication() {
        userController = SpringContextUtil.getBean(UserController.class);
        userName = field.textProperty().getValue();
        passWord = passwordField.textProperty().getValue();
        toCompare = Tools.judgeAccountAndPassword(userName, passWord);
        adminView.setUserName(userName);
        employeesView.setUserName(userName);
        if (!toCompare.equals("")) {
            ((Label) selector(loginView, "errorTip")).setText(toCompare);
        } else {
            ((Label) selector(loginView, "errorTip")).setText("");
            if (userController.queryAccountStatus(userName) == null) {
                if (userController.selectByUserNameAndPassword(userName, passWord) != null) {
                    if (userName.contains("admin")) {
                        initAdmin();
                    } else if (userName.contains("sta")) {
                        initEmploy();
                    }
                    userController.setUserName(userName);
                    userController.addStatus(new AccountStatus(0L, userName, "在线"));
                    loginView.hide();
                    loginView.clear();
                } else {
                    ((Label) selector(loginView, "errorTip")).setText(userName + "账号或密码错误");
                }
            } else {
                ((Label) selector(loginView, "errorTip")).setText(userName + "已经登录，请勿重复登录");
            }
        }
    }

    /**
     * 管理界面的相应的初始化以及事件的初始化
     */
    public void initAdmin() {

        backGroundPane = (Pane) selector(adminView, "backGroundPane");
        searchPane = (Pane) selector(adminView, "searchPane");
        searchField = (TextField) selector(adminView, "searchField");
        loginTitle = (Label) selector(adminView, "loginTitle");
        messagePane = (Pane) selector(adminView, "messagePane");
        editPane = (Pane) selector(adminView, "editPane");
        usersPane = (Pane) selector(adminView, "usersPane");
        logsPane = (Pane) selector(adminView, "logsPane");
        rightInteractional = (Pane) selector(adminView, "rightInteractional");
        dialogTitle = (Label) selector(adminView, "dialogTitle");
        filePane = (Pane) selector(adminView, "filePane");
        picturePane = (Pane) selector(adminView, "picturePane");
        chatInputField = (TextArea) selector(adminView, "chatInputField");
        sandButton = (Button) selector(adminView, "sandButton");
        mainBodyPane = (Pane) selector(adminView, "mainBodyPane");
        removeStyle = (Button) selector(logPane, "removeStyle");


        observableList = FXCollections.observableArrayList(param -> {
            SimpleStringProperty[] array = new SimpleStringProperty[]{
                    param.getUserNameProperty(),
                    param.getEmpNameProperty(),
                    param.getStartTimeProperty(),
                    param.getEventDescriptionProperty()};
            return array;
        });
        messageList = new ListView<>(observableList);
        messageListAttribute();
        mainBodyPane.getChildren().add(messageList);//

        dateList = new ArrayList<>();
        userController.setDateList(dateList);

        searchField.setFocusTraversable(false);
        loginTitle.setText(field.textProperty().getValue());
        positioning = rightInteractional;
        eventListeners();
        adminView.show();
        admin();

    }

    private void messageListAttribute() {
        messageList.setPrefHeight(680);
        messageList.setPrefWidth(1180);
        messageList.setLayoutX(0);
        messageList.setLayoutY(0);
    }

    private void admin() {
        PauseTransition pause = new PauseTransition(Duration.millis(2000));
        pause.setOnFinished(
                e -> {
                    Task task = new Task() {
                        @Override
                        protected Object call() throws Exception {
                            exceptionTablesMessage = userController.queryLatestException();
                            return new Object();
                        }
                    };
                    task.run();
                    adminViewP();
                    pause.playFromStart(); // loop again
                });
        pause.play();
    }

    public void adminViewP() {
        if (messageList.getItems().size() != 0) {
            mark = 0;
            messageList.getItems().clear();
        } else {
            mark = 1;
        }
        adminObservableList = messageList.getItems();

        informDataList = new ArrayList<>();
        if (exceptionTablesMessage.size() != 0) {
            for (ExceptionTable exceptionTable : exceptionTablesMessage) {
                userAccName = exceptionTable.getUserName();
                emName = userController.QueryEmpName(userAccName).getEmpName();
                startTime = exceptionTable.getStartTime();
                problemType = exceptionTable.getProblemType();
                InformData informData = new InformData(userName, startTime, userAccName,
                        emName, startTime.toLocalDateTime().toString().replace("T", " "), problemType);
                adminObservableList.addAll(informData);
            }
        }

        messageList.setCellFactory(new Callback<ListView<InformData>, ListCell<InformData>>() {
            @Override
            public ListCell<InformData> call(ListView<InformData> param) {
                ListCell<InformData> listCell = new ListCell<InformData>() {
                    @Override
                    protected void updateItem(InformData item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty || item == null) {
                            this.setText(null);
                            this.setGraphic(null);
                        } else {
                            NoticeInformation noticeInfoPane = new NoticeInformation(item);
                            this.setGraphic(noticeInfoPane);
                        }
                    }
                };
                return listCell;
            }
        });
    }

    /**
     * 监听事件封装方法eventListeners()
     */
    private void eventListeners() {
        backGroundPane.setOnMouseClicked(event -> {
            backGroundPane.requestFocus();
        });

        searchField.setOnKeyPressed(event -> search());
        searchPane.setOnMouseClicked(event -> search());

        messagePane.setOnMouseClicked(event -> messages());
        editPane.setOnMouseClicked(event -> edits());
        usersPane.setOnMouseClicked(event -> users());
        logsPane.setOnMouseClicked(event -> logs());

        removeStyle.setOnMouseClicked(event -> remove());


    }

    private void remove() {
//        List<ExceptionInfo> logTableModels = logTableView.getItems();
        logs();
    }


    /**
     * 将searchPane的鼠标单击事件和键盘按下事件的业务逻辑抽离出来
     */
    private void search() {
        String findContent = searchField.textProperty().getValue();

    }

    /**
     * 判断positioning是否是backGroundPane的子容器
     * 是则返回true
     *
     * @return
     */
    private boolean compare() {
        return backGroundPane.equals(positioning.getParent());
    }

    /**
     * messagePane的业务处理
     */
    private void messages() {
        if (compare()) {
            backGroundPane.getChildren().removeAll(positioning);
            backGroundPane.getChildren().addAll(rightInteractional);
        }
        positioning = rightInteractional;

    }

    /**
     * editPane的业务处理
     */
    private void edits() {
        editsInit();
        if (compare()) {
            backGroundPane.getChildren().removeAll(positioning);
            releaseP.setLayoutX(110);
            releaseP.setLayoutY(50);
            backGroundPane.getChildren().addAll(releaseP);
        }
        positioning = releaseP;

        editsListener();


    }

    private void editsListener() {
        releaseNowButton.setOnAction(event -> {
            title = titleFiled.textProperty().getValue().trim();
            sander = sanderFiled.textProperty().getValue().trim();
            content = contentFiled.textProperty().getValue().trim();
            nowTime = DateTool.dateNow();
            if (timestampList.size() == 0) {
                userController.addAnnouncement(new Announcement(0L, title, sander, content, nowTime));
                timestampList.add(nowTime);
            } else if (timestampList.size() != 0) {
                if (((nowTime.getTime() - timestampList.get((int) emp).getTime()) / 1000) < 15) {

                } else {
                    userController.addAnnouncement(new Announcement(0L, title, sander, content, nowTime));
                }
                System.out.println(nowTime.getTime() + "和" + timestampList.get((int) emp).getTime() + "相差：\n" + (nowTime.getTime() - timestampList.get((int) emp).getTime()) / 1000);
                timestampList.add(nowTime);
                emp++;
            }
            titleFiled.setText("");
            sanderFiled.setText("");
            contentFiled.setText("");

        });

    }

    private void editsInit() {
        releaseP = (Pane) selector(releasePane, "releasePane");
        titleFiled = (TextField) selector(releasePane, "titleFiled");
        sanderFiled = (TextField) selector(releasePane, "sanderFiled");
        contentFiled = (TextArea) selector(releasePane, "contentFiled");
        publishedList = (ListView<String>) selector(releasePane, "publishedList");
        releaseNowButton = (Button) selector(releasePane, "releaseNowButton");

    }

    /**
     * userPane的业务处理
     */
    private void users() {
        employeesTbList = userController.queryAllEmployee();
        userP = (Pane) selector(userPane, "userPane");
        if (compare()) {
            backGroundPane.getChildren().removeAll(positioning);
            userP.setLayoutX(110);
            userP.setLayoutY(50);
            backGroundPane.getChildren().addAll(userP);
        }
        positioning = userP;
        if (employeesTbList != null) {
            userDataLoad();
        }
    }

    private void userDataLoad() {
        Platform.runLater(() -> {
            userList = FXCollections.observableArrayList();
            for (EmployeeInformation employeeInformation : employeesTbList) {
                userList.add(new EmployeesTb(employeeInformation, false));
            }
            if (userList != null) {
                userTableView = new TableView<>(userList);
                TableColumn<EmployeesTb, Boolean> table_selected = new TableColumn<>("选择");
                table_selected.setCellValueFactory(param -> param.getValue().isSelectedProperty());
                table_selected.setCellFactory(new Callback<TableColumn<EmployeesTb, Boolean>, TableCell<EmployeesTb, Boolean>>() {
                    @Override
                    public TableCell<EmployeesTb, Boolean> call(TableColumn<EmployeesTb, Boolean> param) {
                        TableCell<EmployeesTb, Boolean> tableCell = new TableCell<EmployeesTb, Boolean>() {
                            @Override
                            protected void updateItem(Boolean item, boolean empty) {
                                super.updateItem(item, empty);
                                if (empty == false && item != null) {
                                    HBox hBox = new HBox();
                                    hBox.setAlignment(Pos.CENTER);
                                    CheckBox selected = new CheckBox();
                                    selected.setSelected(item);
                                    hBox.getChildren().add(selected);
                                    this.setGraphic(hBox);
                                }
                            }
                        };
                        return tableCell;
                    }
                });

                TableColumn<EmployeesTb, Number> table_id = new TableColumn<>("编号");
                table_id.setCellValueFactory(param -> param.getValue().idProperty());

                TableColumn<EmployeesTb, String> table_username = new TableColumn<>("员工号");
                table_username.setCellValueFactory(param -> param.getValue().userNameProperty());

                TableColumn<EmployeesTb, String> table_empName = new TableColumn<>("员工姓名");
                table_empName.setCellValueFactory(param -> param.getValue().empNameProperty());


                TableColumn<EmployeesTb, String> table_saddress = new TableColumn<>("家庭住址");
                table_saddress.setCellValueFactory(param -> param.getValue().addressProperty());


                TableColumn<EmployeesTb, String> table_contact = new TableColumn<>("联系方式");
                table_contact.setCellValueFactory(param -> param.getValue().contactProperty());

                TableColumn<EmployeesTb, String> table_sex = new TableColumn<>("性别");
                table_sex.setCellValueFactory(param -> param.getValue().sexProperty());


                table_selected.prefWidthProperty().bind(userTableView.widthProperty().multiply(0.05));
                table_id.prefWidthProperty().bind(userTableView.widthProperty().multiply(0.05));
                table_username.prefWidthProperty().bind(userTableView.widthProperty().multiply(0.10));
                table_empName.prefWidthProperty().bind(userTableView.widthProperty().multiply(0.10));
                table_saddress.prefWidthProperty().bind(userTableView.widthProperty().multiply(0.40));
                table_contact.prefWidthProperty().bind(userTableView.widthProperty().multiply(0.20));
                table_sex.prefWidthProperty().bind(userTableView.widthProperty().multiply(0.10));


                userTableView.getColumns().add(table_selected);
                userTableView.getColumns().add(table_id);
                userTableView.getColumns().add(table_username);
                userTableView.getColumns().add(table_empName);
                userTableView.getColumns().add(table_saddress);
                userTableView.getColumns().add(table_contact);
                userTableView.getColumns().add(table_sex);
                userAttributeSet();
                userP.getChildren().add(userTableView);
            }


        });
    }

    private void userAttributeSet() {
        userTableView.setPrefWidth(1170);
        userTableView.setPrefHeight(620);
        userTableView.setLayoutX(5);
        userTableView.setLayoutY(50);
        userTableView.setStyle("-fx-background-insets: 0;-fx-padding: 0;");
    }

    /**
     * logPane的业务处理
     */
    private void logs() {
        exceptionTables = userController.queryExceptionTableList();
        logP = (Pane) selector(logPane, "logPane");
        if (compare()) {
            backGroundPane.getChildren().removeAll(positioning);
            logP.setLayoutX(110);
            logP.setLayoutY(50);
            backGroundPane.getChildren().addAll(logP);
        }
        positioning = logP;
        if (exceptionTables != null) {
            logsDataLoad();
        }
    }

    //表格数据数据填充
    private void logsDataLoad() {
        Platform.runLater(() -> {
            logsList = FXCollections.observableArrayList();
            for (ExceptionTable exceptionTable : exceptionTables) {
                logsList.add(new ExceptionInfo(exceptionTable, false));
            }
            if (logsList != null) {
                logTableView = new TableView<>(logsList);
                TableColumn<ExceptionInfo, Boolean> table_selected = new TableColumn<>("选择");
                table_selected.setCellValueFactory(param -> param.getValue().getIsSelectedProperty());
                table_selected.setCellFactory(new Callback<TableColumn<ExceptionInfo, Boolean>, TableCell<ExceptionInfo, Boolean>>() {
                    @Override
                    public TableCell<ExceptionInfo, Boolean> call(TableColumn<ExceptionInfo, Boolean> param) {
                        TableCell<ExceptionInfo, Boolean> tableCell = new TableCell<ExceptionInfo, Boolean>() {
                            @Override
                            protected void updateItem(Boolean item, boolean empty) {
                                super.updateItem(item, empty);
                                if (empty == false && item != null) {
                                    HBox hBox = new HBox();
                                    hBox.setAlignment(Pos.CENTER);
                                    CheckBox selected = new CheckBox();
                                    selected.setSelected(item);
                                    hBox.getChildren().add(selected);
                                    this.setGraphic(hBox);
                                }
                            }
                        };
                        return tableCell;
                    }
                });

                TableColumn<ExceptionInfo, Number> table_id = new TableColumn<>("编号");
                table_id.setCellValueFactory(param -> param.getValue().getIdProperty());

                TableColumn<ExceptionInfo, String> table_username = new TableColumn<>("员工号");
                table_username.setCellValueFactory(param -> param.getValue().getUserNameProperty());

                TableColumn<ExceptionInfo, String> table_superior = new TableColumn<>("上级号");
                table_superior.setCellValueFactory(param -> param.getValue().getSuperiorNumProperty());


                TableColumn<ExceptionInfo, String> table_start = new TableColumn<>("开始时间");
                table_start.setCellValueFactory(param -> param.getValue().getStartTimeProperty());


                TableColumn<ExceptionInfo, String> table_end = new TableColumn<>("处理时间");
                table_end.setCellValueFactory(param -> param.getValue().getEndTimeProperty());

                TableColumn<ExceptionInfo, String> table_processing = new TableColumn<>("处理类型");
                table_processing.setCellValueFactory(param -> param.getValue().getIsProcessingProperty());

                TableColumn<ExceptionInfo, String> table_problemType = new TableColumn<>("异常类型");
                table_problemType.setCellValueFactory(param -> param.getValue().getProblemTypeProperty());

                TableColumn<ExceptionInfo, Number> table_proLevel = new TableColumn<>("处理等级");
                table_proLevel.setCellValueFactory(param -> param.getValue().getProcessingLevelProperty());

                table_selected.prefWidthProperty().bind(logTableView.widthProperty().multiply(0.05));
                table_id.prefWidthProperty().bind(logTableView.widthProperty().multiply(0.05));
                table_username.prefWidthProperty().bind(logTableView.widthProperty().multiply(0.10));
                table_superior.prefWidthProperty().bind(logTableView.widthProperty().multiply(0.10));
                table_start.prefWidthProperty().bind(logTableView.widthProperty().multiply(0.20));
                table_end.prefWidthProperty().bind(logTableView.widthProperty().multiply(0.20));
                table_processing.prefWidthProperty().bind(logTableView.widthProperty().multiply(0.10));
                table_problemType.prefWidthProperty().bind(logTableView.widthProperty().multiply(0.10));
                table_proLevel.prefWidthProperty().bind(logTableView.widthProperty().multiply(0.1));

                logTableView.getColumns().add(table_selected);
                logTableView.getColumns().add(table_id);
                logTableView.getColumns().add(table_username);
                logTableView.getColumns().add(table_superior);
                logTableView.getColumns().add(table_start);
                logTableView.getColumns().add(table_end);
                logTableView.getColumns().add(table_processing);
                logTableView.getColumns().add(table_problemType);
                logTableView.getColumns().add(table_proLevel);
                logsAttributeSet();
                logP.getChildren().add(logTableView);
            }


        });
    }

    private void logsAttributeSet() {
        logTableView.setPrefWidth(1170);
        logTableView.setPrefHeight(620);
        logTableView.setLayoutX(5);
        logTableView.setLayoutY(50);
        logTableView.setStyle("-fx-background-insets: 0;-fx-padding: 0;");
    }

    /**
     * fieldPane的业务处理
     */
    private void fields() {
    }

    /**
     * picturePane的业务处理
     */
    private void pictures() {
    }

    /**
     * sandsPane的业务处理
     */
    private void sands() {
    }


    public void sceneListener() {

    }

    /**
     * 员工操作界面
     */
    private void initEmploy() {

        empPane = (Pane) selector(employeesView, "empPane");
        blueButton = (Button) selector(employeesView, "blueButton");
        yellowButton = (Button) selector(employeesView, "yellowButton");
        greenButton = (Button) selector(employeesView, "greenButton");
        redButton = (Button) selector(employeesView, "redButton");
        emlLoginTitle = (Label) selector(employeesView, "loginTitle");
        mainBodyPane = (StackPane) selector(employeesView, "mainBodyPane");
        bottomPane = (Pane) selector(employeesView, "bottomPane");
        floatMessage = (StackPane) selector(employeesView, "floatMessage");
        redPoint = (Circle) selector(employeesView, "redPoint");

        locationNum = (Button) selector(employeesView, "locationNum");
        workNum = (Button) selector(employeesView, "workNum");
        empName = (Button) selector(employeesView, "empName");

        mesDiaBox = (Pane) selector(messageDialog, "mesDiaBox");
        diaMessage = (ListView<InformData>) selector(messageDialog, "diaMessage");

        emlLoginTitle.setText(field.textProperty().getValue());
        intiFloatLitView();
        positioningEmp = bottomPane;
        employListener();
        employees();
        employeesView.show();


    }

    private void employees() {
        PauseTransition pause = new PauseTransition(Duration.millis(1000));
        pause.setOnFinished(
                e -> {
                    Task task = new Task() {
                        @Override
                        protected Object call() throws Exception {
                            announcement = userController.queryLatestAnnouncements();
                            return new Object();
                        }
                    };
                    query++;
                    task.run();
                    employeesBackground();
                    pause.playFromStart(); // loop again
                });
        pause.play();
    }

    private void employeesBackground() {
        if (query <= 10) {
            System.out.println("公告剩余关闭时间:" + query);
            if (announcement != null) {
                if (announcementList.size() == 0) {
                    announcementList.add(announcement);
                    showAnnouncement();
                } else {
                    if (!announcement.getSendTime().equals(announcementList.get(announcementList.size() - 1).getSendTime())) {
                        showAnnouncement();
                        announcementList.remove(announcementList.size() - 1);
                        announcementList.add(announcement);
                    }
                }
            }

        } else {
            if (stringDialog != null && stringDialog.isShowing()) {
                stringDialog.close();
            } else {

            }
            query = 0;
        }

    }


    private void isDialogShowing() {

    }


    private void showAnnouncement() {
        stringDialog = new Dialog<>();
        stringDialog.getDialogPane().setPrefSize(300, 300);
        stringDialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
        stringDialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        stringDialog.getDialogPane().lookupButton(ButtonType.CLOSE);
        stringDialog.getDialogPane().lookupButton(ButtonType.OK);
        stringDialog.setTitle("通知");
        stringDialog.setHeaderText("标题:" + announcement.getTitle() + "\n发送者:" + announcement.getSender() + "\n发送时间:" + announcement.getSendTime().toLocalDateTime().toString().replace("T", " "));
        stringDialog.setContentText(announcement.getContent());
        stringDialog.show();
    }


    private void employListener() {
        emlLoginTitle.setOnMouseClicked(event -> empAccountInfo());
        blueButton.setOnMouseClicked(event -> blue());

        yellowButton.setOnMouseClicked(event -> yellow());
        greenButton.setOnMouseClicked(event -> green());
        redButton.setOnMouseClicked(event -> red());

        locationNum.setOnMouseClicked(event -> locationNumber());
        workNum.setOnMouseClicked(event -> workNumber());
        empName.setOnMouseClicked(event -> employName());
        floatMessage.setOnMouseClicked(event -> messageDialog());
    }

    private boolean compareEmp() {

        return mainBodyPane.equals(positioningEmp.getParent());
    }

    private void empAccountInfo() {
        if (compareEmp()) {
            mainBodyPane.getChildren().removeAll(positioning);
            mainBodyPane.getChildren().set(0, bottomPane);
        }
        positioningEmp = bottomPane;
        if (!mainBodyPane.equals(floatMessage.getParent())) mainBodyPane.getChildren().addAll(floatMessage);

    }

    public String queryEmployeesSuperior() {
        superiorNum = userController.queryEmployeesSuperior(userName).getSuperiorNum();
        return superiorNum;
    }

    public String queryEmployeesSuperior2() {
        superiorNum2 = userController.queryEmployeesSuperior(superiorNum).getSuperiorNum();
        return superiorNum2;
    }


    private void blue() {
        userController.setDate(DateTool.dateNow());
        userController.setCommandType(CommandType.LACK_MATERIAL);
        materialPane = (Pane) selector(lackMatePane, "materialPane");
        unitSelect = (ComboBox<String>) selector(lackMatePane, "unitSelect");
        nameMaterial = (ComboBox<String>) selector(lackMatePane, "nameMaterial");
        materialNumber = (ComboBox<String>) selector(lackMatePane, "materialNumber");
        specifications = (ComboBox<String>) selector(lackMatePane, "specifications");
        InventoryQuantity = (ComboBox<Long>) selector(lackMatePane, "InventoryQuantity");
        needNumber = (TextField) selector(lackMatePane, "needNumber");
        submitButton = (Button) selector(lackMatePane, "submitButton");

        if (compareEmp()) {
            mainBodyPane.getChildren().removeAll(positioning);
            mainBodyPane.getChildren().set(0, materialPane);
        }
        positioningEmp = materialPane;
        if (!mainBodyPane.equals(floatMessage.getParent())) mainBodyPane.getChildren().addAll(floatMessage);
        emp("缺料");
    }


    private void yellow() {
        userController.setDate(DateTool.dateNow());
        userController.setCommandType(CommandType.QUALITY);
        partsPane = (Pane) selector(qualityPane, "partsPane");
        nameMaterialP = (ComboBox<String>) selector(qualityPane, "nameMaterialP");
        materialNumberP = (ComboBox<String>) selector(qualityPane, "materialNumberP");
        specificationsP = (ComboBox<String>) selector(qualityPane, "specificationsP");
        unitSelectP = (ComboBox<String>) selector(qualityPane, "unitSelectP");
        numProblemsP = (TextField) selector(qualityPane, "numProblemsP");
        reasonDescriptionP = (TextField) selector(qualityPane, "reasonDescription");
        submitForm = (Button) selector(qualityPane, "submitForm");
        if (compareEmp()) {
            mainBodyPane.getChildren().removeAll(positioning);
            mainBodyPane.getChildren().set(0, partsPane);
        }
        positioningEmp = partsPane;
        if (!mainBodyPane.equals(floatMessage.getParent())) mainBodyPane.getChildren().addAll(floatMessage);
        emp("质量");

    }

    private void green() {
        userController.setCommandType(CommandType.CALL);


    }

    private void red() {
        userController.setDate(DateTool.dateNow());
        userController.setCommandType(CommandType.SCRAM);
        emp("设备");

    }

    private void emp(String problemType) {
        Task task1 = new Task() {
            @Override
            protected Object call() throws Exception {
                inventoryTables = userController.queryWarehouse();
                if ("缺料".equals(problemType)) {
                    showWarehouse();
                } else if ("质量".equals(problemType)) {
                    showQuality();
                }

                return new Object();
            }
        };
        task1.run();

        if (count == 0) {
            PauseTransition pause = new PauseTransition(Duration.millis(1000));
            pause.setOnFinished(
                    e -> {
                        Task task = new Task() {
                            @Override
                            protected Object call() throws Exception {
                                queryEmployeesSuperior();
                                return new Object();
                            }
                        };
                        task.run();

                        count++;
                        System.out.println(count + "秒");
                        if (count >= 0 && count < 30) {
                            if (count == 1) {
                                userController.addExceptionTable(new ExceptionTable(0L,
                                        userName, null, userController.getDate(),
                                        null, null, problemType, 1L));
                                userController.addExceptionStatus(new ExceptionStatus(0L, userName, superiorNum,
                                        userController.getDate(), 1L, "等待处理"));

                            }
                            System.out.println("userName" + userName + "-----" + "" + userController.getDate());
                            ExceptionStatus exceptionStatus = userController.queryExceptionStatus(userName, userController.getDate());
                            System.out.println(exceptionStatus);
                            if (exceptionStatus != null) {
                                System.out.println("nihao");
                                if ("已处理".equals(exceptionStatus.getProcessingState())) {
                                    System.out.println("输出");
                                    count = 0;
                                    return;
                                } else {
                                    log.info("异常等待处理中....");
                                }
                            }
                        } else if (count >= 30 && count < 60) {
                            if (count == 31) {
                                if (superiorNum != null && userController.getDate() != null) queryEmployeesSuperior2();
                                System.out.println("上级的上级" + superiorNum2);
                                System.out.println("30---->" + userController.getDate());
                                userController.updateStatus(userName, userController.getDate(), 2L, superiorNum2);
                            }
                            System.out.println(userName);
                            ExceptionStatus exceptionStatus = userController.queryExceptionStatus(userName, userController.getDate());
                            if (exceptionStatus != null) {
                                if ("已处理".equals(exceptionStatus.getProcessingState())) {
                                    count = 0;
                                    return;
                                } else {
                                    log.info("异常等待处理中....");
                                }
                            }
                        } else if (count >= 60) {
                            if (count == 61) {
                                userController.updateStatus2(userName, userController.getDate(), "超时,未处理");
                                count = 0;
                                return;
                            }
                        }
                        pause.playFromStart(); // loop again
                    });
            pause.play();
        }
    }

    private void showQuality() {

        if (inventoryTables != null) {
            if (nameMaterialP.getItems().size() != 0 &&
                    materialNumberP.getItems().size() != 0 &&
                    specificationsP.getItems().size() != 0 &&
                    unitSelectP.getItems().size() != 0) {
                nameMaterialP.getItems().clear();
                materialNumberP.getItems().clear();
                specificationsP.getItems().clear();
                unitSelectP.getItems().clear();
            }
            for (InventoryTable inventoryTable : inventoryTables) {
                nameMaterialP.getItems().addAll(inventoryTable.getMaterialName());
                materialNumberP.getItems().addAll(inventoryTable.getMaterialNumber());
                specificationsP.getItems().addAll(inventoryTable.getSpecifications());
                unitSelectP.getItems().addAll(inventoryTable.getUnit());
            }
            showQualityListener();
        }

    }

    private void showQualityListener() {
        nameMaterialP.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            materialNumberP.getSelectionModel().select((Integer) newValue);
            specificationsP.getSelectionModel().select((Integer) newValue);
            unitSelectP.getSelectionModel().select((Integer) newValue);
        });
        submitForm.setOnAction(event -> submitFormListener());
    }

    private void submitFormListener() {
        problemsNumber = numProblemsP.textProperty().getValue();

        cause = reasonDescriptionP.textProperty().getValue();

        userController.addQualityProblem(new QualityProblem(0L,
                userName, nameMaterialP.getValue(),
                materialNumberP.getValue(),
                specificationsP.getValue(),
                DateTool.dateNow(), Long.parseLong(problemsNumber), cause));


    }


    private void showWarehouse() {
        if (inventoryTables != null) {
            if (unitSelect.getItems().size() != 0 &&
                    nameMaterial.getItems().size() != 0 &&
                    materialNumber.getItems().size() != 0 &&
                    specifications.getItems().size() != 0 &&
                    InventoryQuantity.getItems().size() != 0) {
                unitSelect.getItems().clear();
                nameMaterial.getItems().clear();
                materialNumber.getItems().clear();
                specifications.getItems().clear();
                InventoryQuantity.getItems().clear();
            }
            for (InventoryTable inventoryTable : inventoryTables) {
                unitSelect.getItems().addAll(inventoryTable.getUnit());
                nameMaterial.getItems().addAll(inventoryTable.getMaterialName());

                materialNumber.getItems().addAll(inventoryTable.getMaterialNumber());
                specifications.getItems().addAll(inventoryTable.getSpecifications());
                InventoryQuantity.getItems().addAll(inventoryTable.getTotalNumber());
            }
            showWarehouseListener();
        }
    }

    private void showWarehouseListener() {

        nameMaterial.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                unitSelect.getSelectionModel().select((Integer) newValue);
                materialNumber.getSelectionModel().select((Integer) newValue);
                specifications.getSelectionModel().select((Integer) newValue);
                InventoryQuantity.getSelectionModel().select((Integer) newValue);
            }
        });

        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                submitButtonListener();
            }
        });
    }

    private void submitButtonListener() {
        System.out.println("11111");
        needNub = needNumber.textProperty().getValue().trim();
        System.out.println("needNub---->" + needNub);
        System.out.println("----->" + (InventoryQuantity.getValue() + 1));
        userController.addAllMissingReceipt(
                new MissingReceipt(0L, userName,
                        nameMaterial.getValue(), materialNumber.getValue(),
                        specifications.getValue(), unitSelect.getValue(),
                        Long.parseLong(needNub), DateTool.dateNow()));
    }

    private void locationNumber() {
    }

    private void workNumber() {
    }

    private void employName() {
    }

    private void messageDialog() {

        userController.setCommandType(CommandType.EMP_NOTE);

        if (compareEmp()) {
            mainBodyPane.getChildren().removeAll(positioning, floatMessage);
            mainBodyPane.getChildren().set(0, mesDiaBox);
        }
        positioningEmp = mesDiaBox;
        empListView();
    }

    private void empListView() {
        PauseTransition pause = new PauseTransition(Duration.millis(2000));
        pause.setOnFinished(
                e -> {
                    Task task = new Task() {
                        @Override
                        protected Object call() throws Exception {
                            ExceptionStatus exceptionStatus = userController.latestQueryState(userName);
                            if (exceptionStatus != null) {
                                exceptionTableListEmp = userController.queryExceptionAll(exceptionStatus.getUserName());
                            }
                            return new Object();
                        }
                    };
                    task.run();
                    empListViewP();
                    pause.playFromStart(); // loop again
                });
        pause.play();
    }

    private void empListViewP() {
        if (floatLitView.getItems().size() != 0) {
            markTwo = 0;
            floatLitView.getItems().clear();
        } else {
            markTwo = 1;
        }
        empObservableList = floatLitView.getItems();

        informDataList = new ArrayList<>();
        if (exceptionTableListEmp != null && exceptionTableListEmp.size() != 0) {
            for (ExceptionTable exceptionTable : exceptionTableListEmp) {
                userAccName = exceptionTable.getUserName();
                emName = userController.QueryEmpName(userAccName).getEmpName();
                startTime = exceptionTable.getStartTime();
                problemType = exceptionTable.getProblemType();
                InformData informData = new InformData(userName, startTime, userAccName, emName, startTime.toLocalDateTime().toString().replace("T", " "), problemType);
                empObservableList.addAll(informData);
            }
        }
        floatLitView.setCellFactory(new Callback<ListView<InformData>, ListCell<InformData>>() {
            @Override
            public ListCell<InformData> call(ListView<InformData> param) {
                ListCell<InformData> listCell = new ListCell<InformData>() {
                    @Override
                    protected void updateItem(InformData item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty || item == null) {
                            this.setText(null);
                            this.setGraphic(null);
                        } else {
                            NoticeInformation noticeInfoPane = new NoticeInformation(item);
                            this.setGraphic(noticeInfoPane);
                        }
                    }
                };
                return listCell;
            }

        });

    }

    private void intiFloatLitView() {
        observableList2 = FXCollections.observableArrayList(param -> {
            SimpleStringProperty[] array = new SimpleStringProperty[]{
                    param.getUserNameProperty(),
                    param.getEmpNameProperty(),
                    param.getStartTimeProperty(),
                    param.getEventDescriptionProperty()};
            return array;
        });
        floatLitView = new ListView<>(observableList2);
        floatLitView.setPrefWidth(680);
        floatLitView.setPrefHeight(570);
        floatLitView.setLayoutX(0);
        floatLitView.setLayoutY(0);
        mesDiaBox.getChildren().add(floatLitView);
    }
}

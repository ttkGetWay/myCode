package com.ashink.graduationdesign.view;


import com.ashink.graduationdesign.controller.UserController;
import com.ashink.graduationdesign.util.SpringContextUtil;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

/**
 * @EmployeesView 员工操作界面
 */
@Data
public class EmployeesView extends ParentWindow{
    private String userName;
    @Autowired
    private UserController userController;
    public EmployeesView() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(fxmlLoader.getClassLoader().getResource("fxml/employees.fxml"));
            root = fxmlLoader.load();
            Scene scene = new Scene(root,720,620);
            scene.setFill(Color.TRANSPARENT);
            setScene(scene);
            initStyle(StageStyle.TRANSPARENT);
            setResizable(false);

            move();
            quit();
            setIcon();
            minimize();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void quit() {
        ((Pane)selector("closePane")).setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                userController = SpringContextUtil.getBean(UserController.class);
                userController.deleteStatus(userName);
                close();
                System.exit(0);
            }
        });
    }

    @Override
    public void minimize() {
        ((Pane)selector("minPane")).setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                setIconified(true);
            }
        });

    }


}

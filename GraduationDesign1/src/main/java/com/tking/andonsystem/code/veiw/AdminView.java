package com.tking.andonsystem.code.veiw;

import com.tking.andonsystem.bean.SpringContextUtil;
import com.tking.andonsystem.bean.SpringContextUtil;
import com.tking.andonsystem.code.viewinterface.*;
import com.tking.andonsystem.controllor.UserController;
import com.tking.andonsystem.mapper.UserMapper;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Date;

/**
 * @AdminView 管理员操作界面
 */
@Data
public class AdminView extends ParentWindow {
    private String userName;
    @Autowired
    private UserController userController;

    public AdminView() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(fxmlLoader.getClassLoader().getResource("fxml/management.fxml"));
            root = fxmlLoader.load();
            Scene scene = new Scene(root, 1300, 740);
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
        ((Pane) selector("closePane")).setOnMouseClicked(new EventHandler<MouseEvent>() {
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
        ((Pane) selector("minPane")).setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                setIconified(true);
            }
        });
    }


}

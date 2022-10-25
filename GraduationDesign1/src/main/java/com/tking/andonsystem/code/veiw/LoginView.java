package com.tking.andonsystem.code.veiw;


import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;

import java.io.IOException;


/**
 * @LoginView 登录界面
 */
public class LoginView extends ParentWindow {
    public Scene scene;

    public LoginView() {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(fxmlLoader.getClassLoader().getResource("fxml/loginDemo.fxml"));
            root = fxmlLoader.load();
            System.out.println("root"+root);
            System.out.println("-------->"+root.toString());
            scene = new Scene(root, 820, 660);
            System.out.println("scene"+scene);
//            scene.setFill(Color.TRANSPARENT);
            scene.setFill(null);
            ((Pane)selector("loginPane")).requestFocus();
            setScene(scene);
            initStyle(StageStyle.TRANSPARENT);
            setResizable(false);
            move();
            quit();
            setIcon();
            minimize();
            setting();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void quit() {
        ((Pane) selector("closePane")).setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

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


    private void setting() {
        ((Pane) selector("settingPane")).setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("点击了设置按钮...");
            }
        });
    }

    public void clear() {
        ((TextField) selector("userNameField")).setText("");
        ((TextField) selector("passWordField")).setText("");
    }

}

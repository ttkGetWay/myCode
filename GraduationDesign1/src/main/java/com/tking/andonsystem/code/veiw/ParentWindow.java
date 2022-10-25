package com.tking.andonsystem.code.veiw;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * @ParentWindow 自定义的一个所有窗体的父类
 */
public abstract class ParentWindow extends Stage {
    Parent root;
    private double oldX;
    private double oldY;

    /**
     * setIcon（）窗体图标不管任何地方都是一样的所以直接设置
     */
    public void setIcon() {
        getIcons().add(new Image("images/subscript.png"));
    }

    /**
     * move（）所有窗体移动方法都一直
     */
    public void move() {
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                oldX = event.getScreenX() - getX();
                oldY = event.getScreenY() - getY();
            }
        });

        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                setX(event.getScreenX() - oldX);
                setY(event.getScreenY() - oldY);
            }
        });
    }

    /**
     * exit()程序退出
     */
    abstract public void quit();

/*-
    /**
     * minimize()程序最小化
     */
    abstract public void minimize();


    /**
     * @return root 获取root属性
     */
    public Parent getRoot() {
        return root;

    }

    public Object selector(String id) {
        return root.lookup("#" + id);
    }



}

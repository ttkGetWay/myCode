package com.ashink.graduationdesign.view;


import javafx.fxml.FXMLLoader;

import java.io.IOException;

/**
 * @Release 发布消息的界面
 */
public class ReleasePane extends ParentPane {
    public ReleasePane() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(fxmlLoader.getClassLoader().getResource("fxml/release.fxml"));
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

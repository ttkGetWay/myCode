package com.ashink.graduationdesign.view;

import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class MessageDialog extends ParentPane{
    public MessageDialog() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(fxmlLoader.getClassLoader().getResource("fxml/mesDialogBox.fxml"));
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.ashink.graduationdesign.view;

import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class LackMaterialPane extends ParentPane {
    public LackMaterialPane() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(fxmlLoader.getClassLoader().getResource("fxml/inTheForm.fxml"));
            root=fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

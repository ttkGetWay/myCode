package com.tking.andonsystem.code.veiw;

import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class QualityPane extends ParentPane{
    public QualityPane() {
        try {
            FXMLLoader fxmlLoader =new FXMLLoader();
            fxmlLoader.setLocation(fxmlLoader.getClassLoader().getResource("fxml/quality.fxml"));
            root=fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

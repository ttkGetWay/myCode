package com.tking.andonsystem.code.veiw;

import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class LogPane extends ParentPane {
    public LogPane() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(fxmlLoader.getClassLoader().getResource("fxml/log.fxml"));
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

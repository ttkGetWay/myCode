package com.tking.andonsystem.code.veiw;

import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class UserPane extends ParentPane {
    public UserPane() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(fxmlLoader.getClassLoader().getResource("fxml/users.fxml"));
            root=fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

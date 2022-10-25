package com.ashink.graduationdesign;

import com.ashink.graduationdesign.controller.ControllerImpl;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        new ControllerImpl().initLogin();
    }
}

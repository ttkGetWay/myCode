package com.tking.andonsystem;

import com.tking.andonsystem.controllor.viewcontroller.ControllerImpl;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        new ControllerImpl().initLogin();
    }
}

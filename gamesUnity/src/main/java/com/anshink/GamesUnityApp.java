package com.anshink;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;

public class GamesUnityApp extends GameApplication {
    @Override
    protected void initSettings(GameSettings gameSettings) {
        gameSettings.setTitle("Games Unity");
        gameSettings.setVersion("1.0");
        gameSettings.setWidth(385);
        gameSettings.setHeight(500);
        System.out.println("我是games unity");
    }

    public static void main(String[] args) {
        launch(args);
    }
}

package com.ashink.graduationdesign.view;

import javafx.scene.Parent;

public abstract class ParentPane {
    Parent root;

    public Parent getRoot() {
        return root;
    }

    public Object selector(String id) {
        return root.lookup("#" + id);
    }

}

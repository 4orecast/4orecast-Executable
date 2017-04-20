package com.forecast.executable;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

/**
 * Created by Zachary on 3/31/2017.
 */
public class Screen {

    private String fxmlFile;
    protected Controller controller;
    private boolean resizeable;

    public Screen(final String fxmlFile, final Controller controller, final boolean resizeable) {
        this.fxmlFile = fxmlFile;
        this.controller = controller;
        this.resizeable = resizeable;
    }

    public String getFxmlFile() {
        return fxmlFile;
    }

    public Controller getController() {
        return controller;
    }

    public boolean isResizeable() {
        return resizeable;
    }

    public Scene genScene() throws IOException {
        final FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFile));
        fxmlLoader.setController(controller);
        final Parent root = fxmlLoader.load();
        root.getStylesheets().addAll("/resources/css/global.css");
        final Scene scene = new Scene(modifyParent(root));
        return modifyScene(scene);
    }

    protected Parent modifyParent(final Parent parent) {
        return parent;
    }

    protected Scene modifyScene(final Scene scene) {
        return scene;
    }
}

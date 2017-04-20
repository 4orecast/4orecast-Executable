package com.forecast.executable;

import javafx.stage.Stage;

/**
 * Created by Zachary on 4/5/2017.
 */
public class PopoutScreen extends Screen {

    private Stage dialog;

    public PopoutScreen(String fxmlFile, boolean resizeable) {
        super(fxmlFile, null, resizeable);
    }

    public Stage getDialog() {
        return dialog;
    }

    public void setDialog(Stage dialog) {
        this.dialog = dialog;
    }

    public void setController(final PopoutController controller) {
        super.controller = controller;
    }
}

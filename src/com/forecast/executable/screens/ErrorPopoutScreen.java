package com.forecast.executable.screens;

import com.forecast.executable.PopoutScreen;
import com.forecast.executable.screens.controllers.ErrorPopoutController;

/**
 * Created by Zachary on 4/10/2017.
 */
public class ErrorPopoutScreen extends PopoutScreen {

    public ErrorPopoutScreen(final String message) {
        super("/resources/fxml/error.fxml", false);
        this.setController(new ErrorPopoutController(this, message));
    }
}

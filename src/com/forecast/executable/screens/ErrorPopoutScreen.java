package edu.wit.sheltonz.forecast.screens;

import edu.wit.sheltonz.forecast.PopoutScreen;
import edu.wit.sheltonz.forecast.screens.controllers.ErrorPopoutController;

/**
 * Created by Zachary on 4/10/2017.
 */
public class ErrorPopoutScreen extends PopoutScreen {

    public ErrorPopoutScreen(final String message) {
        super("/resources/fxml/error.fxml", false);
        this.setController(new ErrorPopoutController(this, message));
    }
}

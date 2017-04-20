package com.forecast.executable.screens;

import com.forecast.executable.PopoutScreen;
import com.forecast.executable.screens.controllers.AboutPopoutController;

/**
 * Created by Zachary on 4/9/2017.
 */
public class AboutPopoutScreen extends PopoutScreen {

    public AboutPopoutScreen() {
        super("/resources/fxml/about.fxml", false);
        this.setController(new AboutPopoutController(this));
    }
}

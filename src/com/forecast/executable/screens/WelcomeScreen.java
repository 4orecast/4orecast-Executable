package com.forecast.executable.screens;

import com.forecast.executable.Screen;
import com.forecast.executable.screens.controllers.WelcomeController;

/**
 * Created by Zachary on 3/31/2017.
 */
public class WelcomeScreen extends Screen {

    public WelcomeScreen() {
        super("/resources/fxml/welcome.fxml", new WelcomeController(), false);
    }
}

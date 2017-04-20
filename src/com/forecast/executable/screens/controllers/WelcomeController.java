package com.forecast.executable.screens.controllers;

import com.forecast.executable.Controller;
import com.forecast.executable.Main;
import com.forecast.executable.screens.PluginsScreen;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

/**
 * Created by Zachary on 3/31/2017.
 */
public class WelcomeController implements Controller {

    @FXML
    private Button continueButton;

    @FXML
    private void continueButtonClick() throws IOException {
        Main.displayScreen(new PluginsScreen());
    }
}

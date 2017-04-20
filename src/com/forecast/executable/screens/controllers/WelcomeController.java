package edu.wit.sheltonz.forecast.screens.controllers;

import edu.wit.sheltonz.forecast.Controller;
import edu.wit.sheltonz.forecast.Main;
import edu.wit.sheltonz.forecast.screens.PluginsScreen;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

/**
 * Created by sheltonz on 3/31/2017.
 */
public class WelcomeController implements Controller {

    @FXML
    private Button continueButton;

    @FXML
    private void continueButtonClick() throws IOException {
        Main.displayScreen(new PluginsScreen());
    }
}

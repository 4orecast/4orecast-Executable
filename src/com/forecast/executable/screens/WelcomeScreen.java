package edu.wit.sheltonz.forecast.screens;

import edu.wit.sheltonz.forecast.Screen;
import edu.wit.sheltonz.forecast.screens.controllers.WelcomeController;

/**
 * Created by sheltonz on 3/31/2017.
 */
public class WelcomeScreen extends Screen {

    public WelcomeScreen() {
        super("/resources/fxml/welcome.fxml", new WelcomeController(), false);
    }
}

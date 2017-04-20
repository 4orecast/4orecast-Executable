package edu.wit.sheltonz.forecast.screens;

import edu.wit.sheltonz.forecast.PopoutScreen;
import edu.wit.sheltonz.forecast.screens.controllers.AboutPopoutController;

/**
 * Created by Zachary on 4/9/2017.
 */
public class AboutPopoutScreen extends PopoutScreen {

    public AboutPopoutScreen() {
        super("/resources/fxml/about.fxml", false);
        this.setController(new AboutPopoutController(this));
    }
}

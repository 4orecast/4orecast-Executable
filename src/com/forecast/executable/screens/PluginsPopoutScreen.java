package edu.wit.sheltonz.forecast.screens;

import edu.wit.sheltonz.forecast.PopoutScreen;
import edu.wit.sheltonz.forecast.screens.controllers.PluginsPopoutController;

/**
 * Created by Zachary on 4/9/2017.
 */
public class PluginsPopoutScreen extends PopoutScreen {

    public PluginsPopoutScreen() {
        super("/resources/fxml/plugins.fxml", false);
        this.setController(new PluginsPopoutController(this));
    }
}

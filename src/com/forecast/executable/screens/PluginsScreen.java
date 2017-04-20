package edu.wit.sheltonz.forecast.screens;

import edu.wit.sheltonz.forecast.Screen;
import edu.wit.sheltonz.forecast.screens.controllers.PluginsController;

/**
 * Created by sheltonz on 3/31/2017.
 */
public class PluginsScreen extends Screen {
    public PluginsScreen() {
        super("/resources/fxml/plugins.fxml", new PluginsController(), false);
    }
}

package com.forecast.executable.screens;

import com.forecast.executable.Screen;
import com.forecast.executable.screens.controllers.PluginsController;

/**
 * Created by Zachary on 3/31/2017.
 */
public class PluginsScreen extends Screen {
    public PluginsScreen() {
        super("/resources/fxml/plugins.fxml", new PluginsController(), false);
    }
}

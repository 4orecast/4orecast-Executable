package com.forecast.executable.screens;

import com.forecast.executable.PopoutScreen;
import com.forecast.executable.screens.controllers.PluginsPopoutController;

/**
 * Created by Zachary on 4/9/2017.
 */
public class PluginsPopoutScreen extends PopoutScreen {

    public PluginsPopoutScreen() {
        super("/resources/fxml/plugins.fxml", false);
        this.setController(new PluginsPopoutController(this));
    }
}

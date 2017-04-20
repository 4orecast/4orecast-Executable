package com.forecast.executable.screens;

import com.forecast.executable.PopoutScreen;
import com.forecast.executable.screens.controllers.NewProjectPopoutController;

/**
 * Created by Zachary on 4/9/2017.
 */
public class NewProjectPopoutScreen extends PopoutScreen {

    public NewProjectPopoutScreen() {
        super("/resources/fxml/new_project.fxml", false);
        this.setController(new NewProjectPopoutController(this));
    }

}

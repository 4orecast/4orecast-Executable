package com.forecast.executable.screens;

import com.forecast.executable.Screen;
import com.forecast.executable.screens.controllers.NewProjectController;

/**
 * Created by Zachary on 4/3/2017.
 */
public class NewProjectScreen extends Screen {

    public NewProjectScreen() {
        super("/resources/fxml/new_project.fxml", new NewProjectController(), false);
    }
}

package com.forecast.executable.screens;

import com.forecast.executable.Screen;
import com.forecast.executable.screens.controllers.ProjectsController;

/**
 * Created by Zachary on 4/3/2017.
 */
public class ProjectsScreen extends Screen {

    public ProjectsScreen() {
        super("/resources/fxml/projects.fxml", new ProjectsController(), false);
    }

}

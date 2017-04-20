package edu.wit.sheltonz.forecast.screens;

import edu.wit.sheltonz.forecast.Screen;
import edu.wit.sheltonz.forecast.screens.controllers.ProjectsController;

/**
 * Created by Zachary on 4/3/2017.
 */
public class ProjectsScreen extends Screen {

    public ProjectsScreen() {
        super("/resources/fxml/projects.fxml", new ProjectsController(), false);
    }

}

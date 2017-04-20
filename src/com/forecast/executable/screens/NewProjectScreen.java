package edu.wit.sheltonz.forecast.screens;

import edu.wit.sheltonz.forecast.Screen;
import edu.wit.sheltonz.forecast.screens.controllers.NewProjectController;

/**
 * Created by Zachary on 4/3/2017.
 */
public class NewProjectScreen extends Screen {

    public NewProjectScreen() {
        super("/resources/fxml/new_project.fxml", new NewProjectController(), false);
    }
}

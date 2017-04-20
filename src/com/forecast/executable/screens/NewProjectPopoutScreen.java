package edu.wit.sheltonz.forecast.screens;

import edu.wit.sheltonz.forecast.PopoutScreen;
import edu.wit.sheltonz.forecast.screens.controllers.NewProjectPopoutController;

/**
 * Created by Zachary on 4/9/2017.
 */
public class NewProjectPopoutScreen extends PopoutScreen {

    public NewProjectPopoutScreen() {
        super("/resources/fxml/new_project.fxml", false);
        this.setController(new NewProjectPopoutController(this));
    }

}

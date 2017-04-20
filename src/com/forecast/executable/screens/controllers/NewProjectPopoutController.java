package edu.wit.sheltonz.forecast.screens.controllers;

import edu.wit.sheltonz.forecast.Main;
import edu.wit.sheltonz.forecast.PopoutController;
import edu.wit.sheltonz.forecast.PopoutScreen;
import edu.wit.sheltonz.forecast.projects.Project;
import edu.wit.sheltonz.forecast.projects.ProjectStub;
import edu.wit.sheltonz.forecast.screens.ErrorPopoutScreen;
import edu.wit.sheltonz.forecast.screens.MainScreen;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Zachary on 4/9/2017.
 */
public class NewProjectPopoutController extends PopoutController {

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField locationTextField;


    public NewProjectPopoutController(PopoutScreen screen) {
        super(screen);
    }

    @FXML
    public void initialize() {
        this.nameTextField.setText("New Project");
        this.locationTextField.setText(Main.getProjectDir().getAbsolutePath());
    }

    @FXML
    public void projectNameChange() {
    }

    @FXML
    public void continueButtonClick() throws IOException {
        final Project project = new Project(new ProjectStub(nameTextField.getText().trim()), new ArrayList<>());
        Main.getProjectManager().setCurrentProject(project);
        final File file = new File(locationTextField.getText().trim(), String.format("%s.proj", project.getStub().getName()));
        if (file.exists()) {
            Main.displayPopout(new ErrorPopoutScreen("A project by that name already exists!"));
            return;
        }
        Main.getProjectManager().saveProject(file, project);
        this.screen.getDialog().close();
        Main.displayScreen(new MainScreen());
    }
}

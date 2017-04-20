package com.forecast.executable.screens.controllers;

import com.forecast.executable.Controller;
import com.forecast.executable.Main;
import com.forecast.executable.projects.Project;
import com.forecast.executable.projects.ProjectStub;
import com.forecast.executable.screens.ErrorPopoutScreen;
import com.forecast.executable.screens.MainScreen;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Zachary on 4/3/2017.
 */
public class NewProjectController implements Controller {

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField locationTextField;

    private boolean locationFocused;

    @FXML
    public void initialize() {
        this.nameTextField.setText("New Project");
        this.locationTextField.setText(Main.getProjectDir().getAbsolutePath());
//        this.locationTextField.setText(String.format("%s%s%s%s", Main.getProjectDir(), File.separator, nameTextField.getText(), File.separator));
//        this.locationTextField.focusedProperty().addListener(new ChangeListener<Boolean>() {
//            @Override
//            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
//                if(newValue) {
//                    locationFocused = true;
//                }
//            }
//        });
    }

    @FXML
    public void projectNameChange() {
//        if(!locationFocused) {
//            this.locationTextField.setText(String.format("%s%s%s%s", Main.getProjectDir(), File.separator, nameTextField.getText(), File.separator));
//        }
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
        Main.displayScreen(new MainScreen());
    }
}

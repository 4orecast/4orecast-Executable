package com.forecast.executable.screens.controllers;

import com.forecast.executable.Controller;
import com.forecast.executable.Main;
import com.forecast.lib.PluginStub;
import com.forecast.executable.screens.ProjectsScreen;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;

/**
 * Created by Zachary on 3/31/2017.
 */
public class PluginsController implements Controller {

    @FXML
    private Button importButton;

    @FXML
    private Button continueButton;

    @FXML
    private GridPane pluginGrid;

    private void updatePluginList() {
        int row = 0, column = 0;
        for (final PluginStub s : Main.getPluginManager().getPlugins()) {
            final Pane pane = new Pane();
            final Label nameLabel = new Label(s.getPluginInfo().getName());
            nameLabel.setLayoutX(10);
            nameLabel.setLayoutY(0);
            nameLabel.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));
            final Label authorLabel = new Label(String.format("by %s", s.getPluginInfo().getAuthor()));
            authorLabel.setLayoutX(10);
            authorLabel.setLayoutY(30);
            pane.getChildren().add(nameLabel);
            pane.getChildren().add(authorLabel);
            pluginGrid.add(pane, row, column);
            row++;
            if (row == 6) {
                row = 1;
                column = 2;
            }
        }
    }

    @FXML
    private void importButtonClick() throws IOException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        final FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        final FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Forecast Plugin (.jar or .class)", "*.jar", "*.class");
        fileChooser.getExtensionFilters().add(filter);
        final File pluginFile = fileChooser.showOpenDialog(Main.getPrimaryStage()).getAbsoluteFile();
        final File newPluginFile = new File(Main.getPluginDir(), pluginFile.getName());
        Files.copy(pluginFile.toPath(), newPluginFile.toPath());
        Main.getPluginManager().registerPlugin(newPluginFile);
        updatePluginList();
    }

    @FXML
    private void continueButtonClick() throws IOException {
//        Main.displayScreen(new DownloadScreen());
        Main.displayScreen(new ProjectsScreen());
    }
}

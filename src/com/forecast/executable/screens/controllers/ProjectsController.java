package edu.wit.sheltonz.forecast.screens.controllers;

import edu.wit.sheltonz.forecast.Controller;
import edu.wit.sheltonz.forecast.Main;
import edu.wit.sheltonz.forecast.projects.Project;
import edu.wit.sheltonz.forecast.screens.MainScreen;
import edu.wit.sheltonz.forecast.screens.NewProjectScreen;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;

/**
 * Created by Zachary on 4/3/2017.
 */
public class ProjectsController implements Controller {

    @FXML
    private AnchorPane projectPane;

    @FXML
    public void newProjectClick() throws IOException {
        Main.displayScreen(new NewProjectScreen());
    }

    @FXML
    public void openProjectClick() throws IOException, ClassNotFoundException {
        final FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        final FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Forecast Project (.proj)", "*.proj");
        fileChooser.getExtensionFilters().add(filter);
        final File file = fileChooser.showOpenDialog(Main.getPrimaryStage()).getAbsoluteFile();
        if (file == null) {
            return;
        }
        final Project project = Main.getProjectManager().loadProject(file);
        Main.getProjectManager().setCurrentProject(project);
        Main.displayScreen(new MainScreen());
    }

    @FXML
    public void initialize() {
        if (Main.getPluginManager().getPlugins().size() <= 0) {
            for (final File f : Main.getPluginDir().listFiles()) {
                if (!(f.getName().endsWith(".jar") || f.getName().endsWith(".class"))) {
                    continue;
                }
                try {
                    Main.getPluginManager().registerPlugin(f);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }
        double y = 20;
        for (final File f : Main.getProjectDir().listFiles()) {
            if (!f.getName().endsWith(".proj")) {
                continue;
            }
            try {
                final Project project = Main.getProjectManager().loadProject(f);
                final Button button = new Button(project.getStub().getName());
                button.getStyleClass().add("button-import");
                button.setPrefSize(150, 30);
                button.setLayoutX(25);
                button.setLayoutY(y);
                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        try {
                            Main.getProjectManager().setCurrentProject(project);
                            Main.displayScreen(new MainScreen());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                projectPane.getChildren().add(button);
                y += 40;
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}

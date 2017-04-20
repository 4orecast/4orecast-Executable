package edu.wit.sheltonz.forecast;

import edu.wit.sheltonz.forecast.lib.PluginManager;
import edu.wit.sheltonz.forecast.lib.data.DataStructure;
import edu.wit.sheltonz.forecast.lib.graph.DataAlias;
import edu.wit.sheltonz.forecast.lib.prediction.Prediction;
import edu.wit.sheltonz.forecast.projects.ProjectManager;
import edu.wit.sheltonz.forecast.screens.ProjectsScreen;
import edu.wit.sheltonz.forecast.screens.WelcomeScreen;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

/**
 * Created by sheltonz on 3/22/2017.
 */
public class Main extends Application {

    private static Stage primaryStage;
    private static PluginManager pluginManager;
    private static ProjectManager projectManager;
    private static Prediction currentPrediction;
    private static DataAlias currentXDataAlias;
    private static DataAlias currentYDataAlias;
    private static DataStructure currentDataStructure;
    private static File projectDir = new File(System.getProperty("user.home"), "/Forecast/");
    private static File pluginDir = new File(projectDir, "/plugins/");
    public static final String VERSION = "v1.0";

    @Override
    public void start(Stage primaryStage) throws Exception {
        Thread.setDefaultUncaughtExceptionHandler(new ErrorHandler());
        pluginManager = new PluginManager();
        projectManager = new ProjectManager();
        Main.primaryStage = primaryStage;
        primaryStage.setTitle("Forecast");
        primaryStage.getIcons().add(new Image("/resources/img/forecast_icon_large.png"));
        if (!projectDir.exists()) {
            displayScreen(new WelcomeScreen());
            projectDir.mkdir();
            pluginDir.mkdir();
        } else {
            displayScreen(new ProjectsScreen());
        }
    }

    public static void displayScreen(final Screen screen) throws IOException {
        primaryStage.setScene(screen.genScene());
        primaryStage.setResizable(screen.isResizeable());
        primaryStage.show();
    }

    public static void displayPopout(final PopoutScreen screen) throws IOException {
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(primaryStage);
        dialog.setResizable(screen.isResizeable());
        screen.setDialog(dialog);
        dialog.setScene(screen.genScene());
        dialog.show();
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static PluginManager getPluginManager() {
        return pluginManager;
    }

    public static ProjectManager getProjectManager() {
        return projectManager;
    }

    public static Prediction getCurrentPrediction() {
        return currentPrediction;
    }

    public static void setCurrentPrediction(Prediction currentPrediction) {
        Main.currentPrediction = currentPrediction;
    }

    public static DataStructure getCurrentDataStructure() {
        return currentDataStructure;
    }

    public static void setCurrentDataStructure(DataStructure currentDataStructure) {
        Main.currentDataStructure = currentDataStructure;
    }


    public static File getProjectDir() {
        return projectDir;
    }

    public static File getPluginDir() {
        return pluginDir;
    }

    public static DataAlias getCurrentXDataAlias() {
        return currentXDataAlias;
    }

    public static void setCurrentXDataAlias(DataAlias currentXDataAlias) {
        Main.currentXDataAlias = currentXDataAlias;
    }

    public static DataAlias getCurrentYDataAlias() {
        return currentYDataAlias;
    }

    public static void setCurrentYDataAlias(DataAlias currentYDataAlias) {
        Main.currentYDataAlias = currentYDataAlias;
    }
}

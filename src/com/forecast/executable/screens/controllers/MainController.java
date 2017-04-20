package edu.wit.sheltonz.forecast.screens.controllers;

import edu.wit.sheltonz.forecast.Controller;
import edu.wit.sheltonz.forecast.Main;
import edu.wit.sheltonz.forecast.lib.graph.DataPoint;
import edu.wit.sheltonz.forecast.projects.Project;
import edu.wit.sheltonz.forecast.screens.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;

/**
 * Created by Zachary on 4/3/2017.
 */
public class MainController implements Controller {

    @FXML
    private LineChart<String, Number> lineChart;

    @FXML
    private ListView listView;

    @FXML
    public void initialize() {
        updateData();
        Main.getPrimaryStage().focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (newValue) {
                    updateData();
                }
            }
        });
//        predictDropdown.getItems().clear();
//        for(final PluginStub p : Main.getPluginManager().getPlugins()) {
//            for(final Prediction pre : p.getPlugin().predictions()) {
//                final MenuItem menuItem = new MenuItem(pre.getName());
//                menuItem.setOnAction(new EventHandler<ActionEvent>() {
//                    @Override
//                    public void handle(ActionEvent event) {
//                        Main.setCurrentPrediction(pre);
//                        System.out.println(pre.getName());
//                    }
//                });
//                predictDropdown.getItems().add(menuItem);
//            }
//        }
    }

    private void updateData() {
        if (lineChart.getData().size() == 0) {
            final XYChart.Series<String, Number> series = new XYChart.Series<>();
            for (final DataPoint p : Main.getProjectManager().getCurrentProject().getDataPoints()) {
                series.getData().add(new XYChart.Data<>(p.getPosX().getValue(), p.getPosY().getData()));
            }
            lineChart.getData().add(series);
        } else if (Main.getProjectManager().getCurrentProject().getDataPoints().size() > lineChart.getData().get(0).getData().size()) {
            for (final DataPoint p : Main.getProjectManager().getCurrentProject().getDataPoints()) {
                lineChart.getData().get(0).getData().add(new XYChart.Data<>(p.getPosX().getValue(), p.getPosY().getData()));
            }
        }
        listView.getItems().clear();
        for (final DataPoint p : Main.getProjectManager().getCurrentProject().getDataPoints()) {
            listView.getItems().add(String.format("(%s, %s)", p.getPosX().getValue(), p.getPosY().getValue()));
        }
    }

    @FXML
    public void predictionButtonClick() throws IOException {
        System.out.println("Reached");
        Main.displayPopout(new PredictPopoutScreen());
    }

    @FXML
    public void importButtonClick() throws IOException {
        Main.displayPopout(new ImportPopoutScreen());
    }

    @FXML
    public void newProjectItemClick() throws IOException {
        Main.displayPopout(new NewProjectPopoutScreen());
    }

    @FXML
    public void openProjectItemClick() throws IOException, ClassNotFoundException {
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
    public void managePluginsItemClick() throws IOException {
        Main.displayPopout(new PluginsPopoutScreen());
    }

    @FXML
    public void deleteDataItemClick() throws IOException {
        final int index = this.listView.getSelectionModel().getSelectedIndex();
        if (index < 0) {
            return;
        }
        Main.getProjectManager().getCurrentProject().getDataPoints().remove(index);
        this.listView.getItems().remove(index);
        this.lineChart.getData().get(0).getData().remove(index);
        Main.getProjectManager().saveCurrentProject();
    }

    @FXML
    public void clearDataItemClick() throws IOException {
        Main.getProjectManager().getCurrentProject().getDataPoints().clear();
        this.listView.getItems().clear();
        this.lineChart.getData().clear();
        Main.getProjectManager().saveCurrentProject();
    }

    @FXML
    public void aboutItemClick() throws IOException {
        Main.displayPopout(new AboutPopoutScreen());
    }
}

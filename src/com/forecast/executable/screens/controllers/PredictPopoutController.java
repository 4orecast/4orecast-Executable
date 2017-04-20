package edu.wit.sheltonz.forecast.screens.controllers;

import edu.wit.sheltonz.forecast.Main;
import edu.wit.sheltonz.forecast.PopoutController;
import edu.wit.sheltonz.forecast.PopoutScreen;
import edu.wit.sheltonz.forecast.lib.PluginStub;
import edu.wit.sheltonz.forecast.lib.graph.DataAlias;
import edu.wit.sheltonz.forecast.lib.graph.DataPoint;
import edu.wit.sheltonz.forecast.lib.prediction.Prediction;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.IOException;

/**
 * Created by sheltonz on 4/4/2017.
 */
public class PredictPopoutController extends PopoutController {


    @FXML
    private ComboBox methodBox;

    @FXML
    private ComboBox axisBox;

    @FXML
    private ComboBox aliasXBox;
    @FXML
    private ComboBox aliasYBox;

    @FXML
    private TextField valueField;

    public PredictPopoutController(PopoutScreen screen) {
        super(screen);
    }

    @FXML
    public void initialize() {
        for (final PluginStub p : Main.getPluginManager().getPlugins()) {
            for (final Prediction pre : p.getPlugin().predictions()) {
                methodBox.getItems().add(pre.getName());
            }
            for (final DataAlias a : p.getPlugin().dataAliases()) {
                aliasXBox.getItems().add(a.getName());
                aliasXBox.valueProperty().addListener(new ChangeListener() {
                    @Override
                    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                        if (a.getName().equals(newValue)) {
                            Main.setCurrentXDataAlias(a);
                        }
                    }
                });
                aliasYBox.getItems().add(a.getName());
                aliasYBox.valueProperty().addListener(new ChangeListener() {
                    @Override
                    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                        if (a.getName().equals(newValue)) {
                            Main.setCurrentYDataAlias(a);
                        }
                    }
                });
            }
        }
        methodBox.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                for (final PluginStub p : Main.getPluginManager().getPlugins()) {
                    for (final Prediction pre : p.getPlugin().predictions()) {
                        if (pre.getName().equals(newValue)) {
                            Main.setCurrentPrediction(pre);
                            break;
                        }
                    }
                }
            }
        });

        axisBox.getItems().addAll("X", "Y");
    }

    @FXML
    private void predictButtonClick() throws IOException {
        if (axisBox.getSelectionModel().getSelectedIndex() == 0) {
            /*Input is X-Axis*/
            final DataPoint dataPoint = Main.getCurrentPrediction().predict(new DataPoint(Main.getCurrentXDataAlias().createStub(this.valueField.getText().trim()), null), Main.getCurrentYDataAlias(), Main.getProjectManager().getCurrentProject().getDataPoints());
            Main.getProjectManager().getCurrentProject().getDataPoints().add(dataPoint);

        } else {
            final DataPoint dataPoint = Main.getCurrentPrediction().predict(new DataPoint(null, Main.getCurrentYDataAlias().createStub(this.valueField.getText().trim())), Main.getCurrentXDataAlias(), Main.getProjectManager().getCurrentProject().getDataPoints());
            Main.getProjectManager().getCurrentProject().getDataPoints().add(dataPoint);
        }
        this.screen.getDialog().close();
        Main.getProjectManager().saveCurrentProject();
    }
}

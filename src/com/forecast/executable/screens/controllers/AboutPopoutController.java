package edu.wit.sheltonz.forecast.screens.controllers;

import edu.wit.sheltonz.forecast.Main;
import edu.wit.sheltonz.forecast.PopoutController;
import edu.wit.sheltonz.forecast.PopoutScreen;
import edu.wit.sheltonz.forecast.lib.ForecastLibrary;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Created by Zachary on 4/9/2017.
 */
public class AboutPopoutController extends PopoutController {

    @FXML
    private Label exeVersionLabel;

    @FXML
    private Label libVersionLabel;

    @FXML
    private Label pluginCountLabel;

    public AboutPopoutController(PopoutScreen screen) {
        super(screen);
    }

    @FXML
    public void initialize() {
        exeVersionLabel.setText(Main.VERSION);
        libVersionLabel.setText(ForecastLibrary.VERSION);
        pluginCountLabel.setText(String.format("%d", Main.getPluginManager().getPlugins().size()));
    }
}

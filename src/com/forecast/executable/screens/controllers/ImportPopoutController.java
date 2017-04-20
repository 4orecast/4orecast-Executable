package com.forecast.executable.screens.controllers;

import com.forecast.executable.Main;
import com.forecast.executable.PopoutController;
import com.forecast.executable.PopoutScreen;
import com.forecast.lib.PluginStub;
import com.forecast.lib.data.DataStructure;
import com.forecast.lib.graph.DataAlias;
import com.forecast.lib.graph.DataPoint;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Zachary on 4/5/2017.
 */
public class ImportPopoutController extends PopoutController {

    @FXML
    private ComboBox structureBox;

    @FXML
    private ComboBox aliasXBox;
    @FXML
    private ComboBox aliasYBox;

    public ImportPopoutController(PopoutScreen screen) {
        super(screen);
    }

    @FXML
    public void initialize() {
        for (final PluginStub p : Main.getPluginManager().getPlugins()) {
            for (final DataStructure s : p.getPlugin().dataStructures()) {
                structureBox.getItems().add(s.getName());
                structureBox.valueProperty().addListener(new ChangeListener() {
                    @Override
                    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                        if (s.getName().equals(newValue)) {
                            Main.setCurrentDataStructure(s);
                        }
                    }
                });
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
    }

    @FXML
    public void openButtonClick() throws IOException {
        final FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        final FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter(String.format("%s formatted file", Main.getCurrentDataStructure().getName()), Main.getCurrentDataStructure().getFileTypes());
        fileChooser.getExtensionFilters().add(filter);
        final File dataFile = fileChooser.showOpenDialog(Main.getPrimaryStage()).getAbsoluteFile();
        final List<DataPoint> data = Main.getCurrentDataStructure().importData(dataFile, Main.getCurrentXDataAlias(), Main.getCurrentYDataAlias());
        System.out.println(Main.getProjectManager().getCurrentProject().getDataPoints());
        Main.getProjectManager().getCurrentProject().getDataPoints().addAll(data);
        this.screen.getDialog().close();
        Main.getProjectManager().saveCurrentProject();
    }

}

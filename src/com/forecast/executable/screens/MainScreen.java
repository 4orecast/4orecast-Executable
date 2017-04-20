package edu.wit.sheltonz.forecast.screens;


import edu.wit.sheltonz.forecast.Main;
import edu.wit.sheltonz.forecast.Screen;
import edu.wit.sheltonz.forecast.screens.controllers.MainController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Region;


/**
 * Created by Zachary on 4/3/2017.
 */
public class MainScreen extends Screen {

    public MainScreen() {
        super("/resources/fxml/main.fxml", new MainController(), true);
    }

    boolean firstHeight, firstWidth;


    @Override
    protected Scene modifyScene(final Scene scene) {
        Main.getPrimaryStage().setTitle(String.format("Forecast: %s", Main.getProjectManager().getCurrentProject().getStub().getName()));
        scene.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (oldValue.doubleValue() == 0) {
                    return;
                }
                if (!firstWidth) {
                    firstWidth = true;
                    return;
                }
                System.out.println(oldValue);
                for (final Node n : scene.getRoot().getChildrenUnmodifiable()) {
                    final Region region = (Region) n;
                    final double xRatio = region.getLayoutX() / oldValue.doubleValue();
                    final double widthRadio = region.getWidth() / oldValue.doubleValue();
                    if (region.getPrefWidth() == Region.USE_COMPUTED_SIZE) {
                        continue;
                    }
                    region.setLayoutX(xRatio * newValue.doubleValue());
                    region.setMinWidth(widthRadio * newValue.doubleValue());
                }
            }
        });
        scene.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (oldValue.doubleValue() == 0) {
                    return;
                }
                if (!firstHeight) {
                    firstHeight = true;
                    return;
                }
                for (final Node n : scene.getRoot().getChildrenUnmodifiable()) {
                    final Region region = (Region) n;
                    final double yRatio = region.getLayoutY() / oldValue.doubleValue();
                    region.setLayoutY(yRatio * newValue.doubleValue());
                    if (region.getPrefHeight() == Region.USE_COMPUTED_SIZE) {
                        continue;
                    }
                    final double heightRadio = region.getHeight() / oldValue.doubleValue();
                    region.setMinHeight(heightRadio * newValue.doubleValue());
                }
            }
        });
        return scene;
    }
}

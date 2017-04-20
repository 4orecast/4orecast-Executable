package com.forecast.executable.screens;

import com.forecast.executable.PopoutScreen;
import com.forecast.executable.screens.controllers.PredictPopoutController;

/**
 * Created by Zachary on 4/4/2017.
 */
public class PredictPopoutScreen extends PopoutScreen {

    public PredictPopoutScreen() {
        super("/resources/fxml/predict_popout.fxml", false);
        this.setController(new PredictPopoutController(this));
    }

}

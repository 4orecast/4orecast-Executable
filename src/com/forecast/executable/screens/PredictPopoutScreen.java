package edu.wit.sheltonz.forecast.screens;

import edu.wit.sheltonz.forecast.PopoutScreen;
import edu.wit.sheltonz.forecast.screens.controllers.PredictPopoutController;

/**
 * Created by sheltonz on 4/4/2017.
 */
public class PredictPopoutScreen extends PopoutScreen {

    public PredictPopoutScreen() {
        super("/resources/fxml/predict_popout.fxml", false);
        this.setController(new PredictPopoutController(this));
    }

}

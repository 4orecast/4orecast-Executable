package edu.wit.sheltonz.forecast.screens;

import edu.wit.sheltonz.forecast.Screen;
import edu.wit.sheltonz.forecast.screens.controllers.DownloadController;

/**
 * Created by sheltonz on 3/31/2017.
 */
public class DownloadScreen extends Screen {
    public DownloadScreen() {
        super("/resources/fxml/download.fxml", new DownloadController(), false);
    }
}

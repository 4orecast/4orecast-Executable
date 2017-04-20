package com.forecast.executable.screens;

import com.forecast.executable.Screen;
import com.forecast.executable.screens.controllers.DownloadController;

/**
 * Created by Zachary on 3/31/2017.
 */
public class DownloadScreen extends Screen {
    public DownloadScreen() {
        super("/resources/fxml/download.fxml", new DownloadController(), false);
    }
}

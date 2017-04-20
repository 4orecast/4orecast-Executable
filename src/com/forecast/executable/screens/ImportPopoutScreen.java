package com.forecast.executable.screens;

import com.forecast.executable.PopoutScreen;
import com.forecast.executable.screens.controllers.ImportPopoutController;

/**
 * Created by Zachary on 4/5/2017.
 */
public class ImportPopoutScreen extends PopoutScreen {

    public ImportPopoutScreen() {
        super("/resources/fxml/import_popout.fxml", false);
        this.setController(new ImportPopoutController(this));
    }

}

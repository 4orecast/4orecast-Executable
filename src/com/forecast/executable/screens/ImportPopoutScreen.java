package edu.wit.sheltonz.forecast.screens;

import edu.wit.sheltonz.forecast.PopoutScreen;
import edu.wit.sheltonz.forecast.screens.controllers.ImportPopoutController;

/**
 * Created by sheltonz on 4/5/2017.
 */
public class ImportPopoutScreen extends PopoutScreen {

    public ImportPopoutScreen() {
        super("/resources/fxml/import_popout.fxml", false);
        this.setController(new ImportPopoutController(this));
    }

}

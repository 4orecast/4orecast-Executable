package edu.wit.sheltonz.forecast.screens.controllers;

import edu.wit.sheltonz.forecast.PopoutController;
import edu.wit.sheltonz.forecast.PopoutScreen;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;


/**
 * Created by Zachary on 4/10/2017.
 */
public class ErrorPopoutController extends PopoutController {

    @FXML
    private TextArea textArea;

    private String message;

    public ErrorPopoutController(PopoutScreen screen, final String message) {
        super(screen);
        this.message = message;
    }

    @FXML
    public void initialize() {
        this.textArea.setText(message);
    }

    @FXML
    public void okayClick() {
        this.screen.getDialog().close();
    }


}

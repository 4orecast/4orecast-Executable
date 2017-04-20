package com.forecast.executable;

/**
 * Created by Zachary on 4/5/2017.
 */
public class PopoutController implements Controller {

    protected PopoutScreen screen;

    public PopoutController(final PopoutScreen screen) {
        this.screen = screen;
    }
}

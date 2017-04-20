package edu.wit.sheltonz.forecast;

import edu.wit.sheltonz.forecast.screens.ErrorPopoutScreen;

import java.io.IOException;

/**
 * Created by Zachary on 4/10/2017.
 */
public class ErrorHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        try {
            String out = e.getLocalizedMessage();
            for (StackTraceElement s : e.getStackTrace()) {
                out = String.format("%s%n%s", out, s);
            }
            Main.displayPopout(new ErrorPopoutScreen(out));
            e.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}

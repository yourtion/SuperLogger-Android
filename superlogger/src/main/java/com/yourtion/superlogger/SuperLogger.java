package com.yourtion.superlogger;

/**
 * Created by Yourtion on 09/01/2017.
 */

public class SuperLogger {

    private static SuperLogger instance;
    private SuperLogger (){}

    public static synchronized SuperLogger getInstance() {
        if (instance == null) {
            instance = new SuperLogger();
        }
        return instance;
    }

}

package com.yourtion.sldemo;

import android.app.Activity;
import android.os.Bundle;

import com.yourtion.superlogger.SuperLogger;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SuperLogger.getInstance();
    }
}

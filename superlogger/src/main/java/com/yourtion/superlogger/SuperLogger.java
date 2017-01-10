package com.yourtion.superlogger;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.IOException;

/**
 * Created by Yourtion on 09/01/2017.
 */

public class SuperLogger {

    private static SuperLogger instance;
    private Context mContext;
    private File mLogDir;
    private File mLogFile;
    private SuperLogger (){}

    public static synchronized SuperLogger getInstance(Context context) {
        if (instance == null) {
            instance = new SuperLogger();
            instance.mContext = context;
            instance.mLogDir = new File(context.getCacheDir(), "SuperLogger");
        }
        return instance;
    }

    public void redirectLogcatToDocumentFolder(String tag) {

        try {
           this.mLogFile = new File( this.mLogDir , System.currentTimeMillis() + ".log" );
            // create log folder
            if ( !this.mLogDir.exists() ) {
                this.mLogDir.mkdir();
            }

            Process process = Runtime.getRuntime().exec( "logcat -c");
            process = Runtime.getRuntime().exec( "logcat -f " + this.mLogFile + " " + tag +":D *:S" );
        } catch ( IOException e ) {
            e.printStackTrace();
        }

    }

    public void listLogDir() {
        if (this.mLogDir.exists()) {
            for (File f : this.mLogFile.listFiles()) {
                //perform here your operation
                Log.e("aaa", f.toString());
            }
        }
    }

}

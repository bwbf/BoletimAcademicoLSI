package boletim.labsi.brunowesley.boletim;

import android.app.Application;
import android.util.Log;

/**
 * Created by wesle on 06/11/2016.
 */

public class BoletimApplication extends Application {
    private static final String TAG = "BoletimApplication";
    private static BoletimApplication instance = null;
    private static int ID;

    public static int getID() {
        return ID;
    }

    public static void setID(int ID) {
        BoletimApplication.ID = ID;
    }

    public static BoletimApplication getInstance(){
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "BoletimApplication.onCreate()");
        instance = this;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        Log.d(TAG, "BoletimApplication.onTerminate()");
    }
}

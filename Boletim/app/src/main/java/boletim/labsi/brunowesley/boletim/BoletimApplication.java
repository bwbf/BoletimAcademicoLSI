package boletim.labsi.brunowesley.boletim;

import android.app.Application;
import android.util.Log;

import java.util.List;

/**
 * Created by wesle on 06/11/2016.
 */

public class BoletimApplication extends Application {
    private static final String TAG = "BoletimApplication";
    private static BoletimApplication instance = null;
    private static int ID;
    private static String A = null;
    private static String B = null;

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

    public static void Comunicador(String descricao, String titulo) {
        A = titulo;
        B = descricao;
    }

    public static String getComunicadorA(){
        return A;
    }
    public static String getComunicadorB(){
        return B;
    }

    public static void setComunicadorA(String a){
         A = a;
    }
    public static void setComunicadorB(String b){
        B = b;
    }

}

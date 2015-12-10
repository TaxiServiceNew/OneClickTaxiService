package com.example.darshanapriyasad.taxi_service.contextconnection;

import android.app.Application;
import android.content.Context;

/**
 * Created by Darshana Priyasad on 12/9/2015.
 */

public class ContextConnection extends Application {

    private static Context context;

    @Override
    public void onCreate(){
        super.onCreate();
        context=getApplicationContext();
    }

    public static Context getCustomAppContext(){
        return context;
    }

}
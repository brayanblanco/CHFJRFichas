package com.braysoft.chfjrfichas;

import java.io.File;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Environment;

public class App extends Application{

    private static Context _context;
    private static File _directorioCasas;
    private static File _directorioPersonajes;
    
    public static final String KEY_CASA = "CASA";
    public static final String KEY_PJ = "PJ";
    

    @Override
    public void onCreate() {
        super.onCreate();
        _context = this;
        _directorioCasas = new File(Environment.getExternalStorageDirectory(),"CHFJR/Casas");
        _directorioPersonajes = new File(Environment.getExternalStorageDirectory(),"CHFJR/Personajes");
        if(!_directorioPersonajes.exists()) _directorioPersonajes.mkdirs();
        if(!_directorioCasas.exists()) _directorioCasas.mkdirs();
    }

    public static Resources getAppResources()
    {
    	return _context.getResources();
    }
    public static Context getContext(){
        return _context;
    }
    
    public static File getDirectorioCasas()
    {
    	return _directorioCasas;
    }
    public static File getDirectorioPersonajes()
    {
    	return _directorioPersonajes;
    }
}
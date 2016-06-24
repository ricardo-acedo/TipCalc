package com.android.acedori.tipcalc;

import android.app.Application;

/**
 * Created by acedori on 09/06/2016.
 */
public class TipCalcApp extends Application{
    private final static String ABOUT_URL = "https://about.me/ricardoacedo7";

    public String getAboutUrl() {
        return ABOUT_URL;
    }
}

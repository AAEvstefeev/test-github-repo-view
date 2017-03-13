package com.example.alexev.npmtest.other;

import android.app.Application;

import com.example.alexev.npmtest.di.AppComponent;
import com.example.alexev.npmtest.di.DaggerAppComponent;
import com.example.alexev.npmtest.di.ModelModule;
import com.example.alexev.npmtest.di.PresenterModule;


public class AppApplication extends Application {
    private static AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = buildComponent();
    }
    protected AppComponent buildComponent() {
        return DaggerAppComponent.builder()
                .modelModule(new ModelModule())
                .presenterModule(new PresenterModule())
                .build();
    }

    public static AppComponent getComponent() {
        return component;
    }
}

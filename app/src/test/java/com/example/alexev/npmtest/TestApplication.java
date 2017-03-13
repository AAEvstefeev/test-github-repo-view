package com.example.alexev.npmtest;


import com.example.alexev.npmtest.di.AppComponent;
import com.example.alexev.npmtest.other.AppApplication;

public class TestApplication extends AppApplication {

    @Override
    protected AppComponent buildComponent() {
        return DaggerTestComponent.builder()
                .build();
    }
}

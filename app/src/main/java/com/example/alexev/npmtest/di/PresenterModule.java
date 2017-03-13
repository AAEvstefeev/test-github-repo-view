package com.example.alexev.npmtest.di;


import com.example.alexev.npmtest.model.Model;
import com.example.alexev.npmtest.model.ModelImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {
    @Provides
    @Singleton
    Model provideDataRepository() {
        return new ModelImpl();
    }

}

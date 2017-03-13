package com.example.alexev.npmtest;


import com.example.alexev.npmtest.di.AppComponent;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ModelTestModule.class, PresenterTestModule.class, ViewTestModule.class, DataTestModule.class})
public interface TestComponent extends AppComponent {




    void inject(RepoListFragmentTest repoListFragmentTest);

    void inject(BaseFragmentTest baseFragmentTest);
}

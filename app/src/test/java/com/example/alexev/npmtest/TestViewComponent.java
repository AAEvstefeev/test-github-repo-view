package com.example.alexev.npmtest;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {TestViewDynamicModule.class})
public interface TestViewComponent  {

    void inject(RepoListFragmentTest in);

}

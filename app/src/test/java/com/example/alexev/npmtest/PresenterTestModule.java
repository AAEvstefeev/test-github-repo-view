package com.example.alexev.npmtest;


import com.example.alexev.npmtest.model.Model;
import com.example.alexev.npmtest.presenters.RepoListPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.subscriptions.CompositeSubscription;

import static org.mockito.Mockito.mock;

@Module

public class PresenterTestModule {

    @Provides
    @Singleton
    Model provideDataRepository() {
        return mock(Model.class);
    }

    @Provides
    CompositeSubscription provideCompositeSubscription() {
        return new CompositeSubscription();
    }

    @Provides
    RepoListPresenter provideRepoListPresenter(){
        return mock(RepoListPresenter.class);
    }

}

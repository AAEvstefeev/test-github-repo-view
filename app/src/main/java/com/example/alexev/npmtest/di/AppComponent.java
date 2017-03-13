package com.example.alexev.npmtest.di;



import com.example.alexev.npmtest.model.ModelImpl;
import com.example.alexev.npmtest.presenters.OwnerDetailPresenter;
import com.example.alexev.npmtest.presenters.RepoListPresenter;

import javax.inject.Singleton;

/**
 * Created by alexev on 18.09.16.
 */

@Singleton
@dagger.Component(modules = {ModelModule.class, PresenterModule.class})
public interface AppComponent {

    void inject(RepoListPresenter dataRepository);


    void inject(OwnerDetailPresenter ownerDetailPresenter);

    void inject(ModelImpl model);


}


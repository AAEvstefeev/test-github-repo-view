package com.example.alexev.npmtest.presenters;


import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.alexev.npmtest.model.Model;
import com.example.alexev.npmtest.model.dto.RepoItem;
import com.example.alexev.npmtest.other.AppApplication;
import com.example.alexev.npmtest.views.RepoListView;

import java.util.List;

import javax.inject.Inject;

import rx.Subscription;

@InjectViewState
public class RepoListPresenter extends MvpPresenter<RepoListView> {
    @Inject
    Model model;
    private Subscription subscriber;


    public void onCreate() {
        AppApplication.getComponent().inject(this);
    }

    public void searchRepo(String searchQuery) {
        getViewState().showProgressBar();
        subscriber = model.getRepoList(searchQuery).subscribe(this::onNext, this::onError);

    }

    private void onNext(List<RepoItem> repoItems) {
        getViewState().showRepoList(repoItems);
    }

    private void onError(Throwable throwable) {
        throwable.printStackTrace();
        String error = throwable.toString();
        getViewState().showError(error);
    }


}

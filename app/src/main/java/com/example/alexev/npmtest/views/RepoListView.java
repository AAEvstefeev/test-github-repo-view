package com.example.alexev.npmtest.views;

import com.arellomobile.mvp.MvpView;
import com.example.alexev.npmtest.model.dto.RepoItem;

import java.util.List;


public interface RepoListView extends MvpView{
    void  showRepoList(List<RepoItem> repoList);

    void showProgressBar();

    void showError(String error);
}

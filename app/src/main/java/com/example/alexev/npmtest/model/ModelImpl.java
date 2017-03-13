package com.example.alexev.npmtest.model;

import com.example.alexev.npmtest.model.api.ApiInterface;
import com.example.alexev.npmtest.model.dto.OwnerDetail;
import com.example.alexev.npmtest.model.dto.RepoItem;
import com.example.alexev.npmtest.model.dto.RepoListResponse;
import com.example.alexev.npmtest.other.AppApplication;
import com.example.alexev.npmtest.other.Const;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.Scheduler;

public class ModelImpl implements Model {

    public static final int COUNT_FIRST_REPO = 20;
    private final Observable.Transformer schedulersTransformer;

    @Inject
    protected ApiInterface apiInterface;

    @Inject
    @Named(Const.UI_THREAD)
    Scheduler uiThread;

    @Inject
    @Named(Const.IO_THREAD)
    Scheduler ioThread;

    public ModelImpl() {
        AppApplication.getComponent().inject(this);
        schedulersTransformer = o -> ((Observable) o).subscribeOn(ioThread)
                .observeOn(uiThread)
                .unsubscribeOn(ioThread);
    }

    @Override
    public Observable<List<RepoItem>> getRepoList(String searchQuery) {
        return apiInterface
                .searchRepo(searchQuery)
                .map(RepoListResponse::getRepoItems)
                .flatMap(Observable::from)
                .take(COUNT_FIRST_REPO)
                .toList()
                .compose(applySchedulers());
    }

    @Override
    public Observable<OwnerDetail> getOwnerDetail(int ownerId) {
        return apiInterface
                .getUserDetail(ownerId)
                .compose(applySchedulers());
    }


    @SuppressWarnings("unchecked")
    private <T> Observable.Transformer<T, T> applySchedulers() {
        return (Observable.Transformer<T, T>) schedulersTransformer;
    }

}

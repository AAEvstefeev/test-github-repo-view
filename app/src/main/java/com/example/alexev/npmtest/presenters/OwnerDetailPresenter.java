package com.example.alexev.npmtest.presenters;


import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.alexev.npmtest.model.Model;
import com.example.alexev.npmtest.model.dto.OwnerDetail;
import com.example.alexev.npmtest.other.AppApplication;
import com.example.alexev.npmtest.views.OwnerDetailView;

import javax.inject.Inject;
@InjectViewState
public class OwnerDetailPresenter extends MvpPresenter<OwnerDetailView> {
    @Inject
    Model model;

    private int ownerId;

    public void onCreate(){
        AppApplication.getComponent().inject(this);
    }

    public void loadData() {
        getViewState().showProgressBar();
        model.getOwnerDetail(ownerId).subscribe(this::onNext, this::onError);
    }

    private void onError(Throwable throwable) {
        throwable.printStackTrace();
        String error = throwable.toString();
        getViewState().showError(error);
    }

    private void onNext(OwnerDetail ownerDetail) {
        getViewState().showDetail(ownerDetail);
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
}

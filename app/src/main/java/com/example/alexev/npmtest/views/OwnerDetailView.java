package com.example.alexev.npmtest.views;

import com.arellomobile.mvp.MvpView;
import com.example.alexev.npmtest.model.dto.OwnerDetail;

/**
 * Created by alexev on 18.09.16.
 */
public interface OwnerDetailView extends MvpView {
    void showDetail(OwnerDetail ownerDetail);

    void showError(String error);

    void showProgressBar();

}

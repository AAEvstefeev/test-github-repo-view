package com.example.alexev.npmtest.model;

import com.example.alexev.npmtest.model.dto.OwnerDetail;
import com.example.alexev.npmtest.model.dto.RepoItem;

import java.util.List;

import rx.Observable;


/**
 * Created by alexev on 18.09.16.
 */
public interface Model {
    Observable<List<RepoItem>> getRepoList(String searchRequest);

    Observable<OwnerDetail> getOwnerDetail(int ownerId);

}

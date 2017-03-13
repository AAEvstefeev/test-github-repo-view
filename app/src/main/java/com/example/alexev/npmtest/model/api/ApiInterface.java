package com.example.alexev.npmtest.model.api;

import com.example.alexev.npmtest.model.dto.OwnerDetail;
import com.example.alexev.npmtest.model.dto.RepoListResponse;

import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by alexev on 18.09.16.
 */
public interface ApiInterface {
    @GET("/search/repositories")
    Observable<RepoListResponse> searchRepo(@Query("q") String searchString);

    @GET("/user/{id}")
    Observable<OwnerDetail> getUserDetail(@Path("id") int ownerId);

}

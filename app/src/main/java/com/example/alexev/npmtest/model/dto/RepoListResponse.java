
package com.example.alexev.npmtest.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class RepoListResponse {

    @SerializedName("total_count")
    @Expose
    private Integer totalCount;
    @SerializedName("incomplete_results")
    @Expose
    private Boolean incompleteResults;
    @SerializedName("items")
    @Expose
    private List<RepoItem> repoItems = new ArrayList<RepoItem>();

    /**
     * 
     * @return
     *     The totalCount
     */
    public Integer getTotalCount() {
        return totalCount;
    }

    /**
     * 
     * @param totalCount
     *     The total_count
     */
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * 
     * @return
     *     The incompleteResults
     */
    public Boolean getIncompleteResults() {
        return incompleteResults;
    }

    /**
     * 
     * @param incompleteResults
     *     The incomplete_results
     */
    public void setIncompleteResults(Boolean incompleteResults) {
        this.incompleteResults = incompleteResults;
    }

    /**
     * 
     * @return
     *     The repoItems
     */
    public List<RepoItem> getRepoItems() {
        return repoItems;
    }

    /**
     * 
     * @param repoItems
     *     The repoItems
     */
    public void setRepoItems(List<RepoItem> repoItems) {
        this.repoItems = repoItems;
    }

}

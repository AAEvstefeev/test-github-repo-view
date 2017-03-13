package com.example.alexev.npmtest.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.alexev.npmtest.R;
import com.example.alexev.npmtest.adapters.RepoListAdapter;
import com.example.alexev.npmtest.common.MvpAppCompatFragment;
import com.example.alexev.npmtest.model.dto.RepoItem;
import com.example.alexev.npmtest.presenters.RepoListPresenter;
import com.example.alexev.npmtest.views.RepoListView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class RepoListFragment extends MvpAppCompatFragment implements RepoListView {

    @Bind(R.id.search_edit_text)
    EditText searchEditText;
    @Bind(R.id.repositories_list_recycler_view)
    RecyclerView repositoriesListRecyclerView;
    @Bind(R.id.search_button)
    Button searchButton;
    @Bind(R.id.repo_list_progress_bar)
    ProgressBar repoListProgressBar;
    @Bind(R.id.repo_list_error_text_view)
    TextView repoListErrorTextView;

    @InjectPresenter
    RepoListPresenter repoListPresenter;

    private RepoListAdapter repoListAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        repoListPresenter.onCreate();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.repo_list_fragment, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRepoList();
    }

    @OnClick(R.id.search_button)
    public void onClick() {
        String searchQuery = searchEditText.getText().toString();
        repoListPresenter.searchRepo(searchQuery);
    }

    public void showProgressBar() {
        repoListProgressBar.setVisibility(View.VISIBLE);
        repositoriesListRecyclerView.setVisibility(View.GONE);
        repoListErrorTextView.setVisibility(View.GONE);
    }

    public void showError(String error) {
        repoListErrorTextView.setText(error);

        repoListProgressBar.setVisibility(View.GONE);
        repositoriesListRecyclerView.setVisibility(View.GONE);
        repoListErrorTextView.setVisibility(View.VISIBLE);
    }

    private void initRepoList() {
        repoListAdapter = new RepoListAdapter(getActivity());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        repositoriesListRecyclerView.setAdapter(repoListAdapter);
        repositoriesListRecyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void showRepoList(List<RepoItem> repoList) {
        repoListProgressBar.setVisibility(View.GONE);
        repoListErrorTextView.setVisibility(View.GONE);
        repositoriesListRecyclerView.setVisibility(View.VISIBLE);
        repoListAdapter.setRepoList(repoList);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}

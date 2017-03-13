package com.example.alexev.npmtest.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.alexev.npmtest.R;
import com.example.alexev.npmtest.common.MvpAppCompatFragment;
import com.example.alexev.npmtest.model.dto.OwnerDetail;
import com.example.alexev.npmtest.presenters.OwnerDetailPresenter;
import com.example.alexev.npmtest.views.OwnerDetailView;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by alexev on 18.09.16.
 */
public class OwnerDetailFragment extends MvpAppCompatFragment implements OwnerDetailView {

    public static final String OWNER_ID = "owner_id";
    @Bind(R.id.detail_owner_name_text_view)
    TextView nameTextView;
    @Bind(R.id.detail_owner_mail_text_view)
    TextView mailTextView;
    @Bind(R.id.detail_owner_company_text_view)
    TextView companyTextView;
    @Bind(R.id.detail_owner_crate_date_repo_text_view)
    TextView crateDateRepoTextView;
    @Bind(R.id.bio_text_view)
    TextView bioTextView;
    @Bind(R.id.detail_owner_avatar_image_view)
    ImageView avatarImageView;
    @Bind(R.id.owner_detail_error_text_view)
    TextView errorTextView;
    @Bind(R.id.owner_detail_progress_bar)
    ProgressBar progressBar;
    @Bind(R.id.detail_layout)
    LinearLayout detailLayout;

    @InjectPresenter
    OwnerDetailPresenter ownerDetailPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ownerDetailPresenter.onCreate();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detail_owner_fragment, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int ownerId = getActivity().getIntent().getIntExtra(OWNER_ID, 0);
        ownerDetailPresenter.setOwnerId(ownerId);
    }

    @Override
    public void onStart() {
        super.onStart();
        ownerDetailPresenter.loadData();
    }

    @Override
    public void showDetail(OwnerDetail ownerDetail) {
        progressBar.setVisibility(View.GONE);
        errorTextView.setVisibility(View.GONE);
        detailLayout.setVisibility(View.VISIBLE);
        setDetailDataToView(ownerDetail);

    }

    private void setDetailDataToView(OwnerDetail ownerDetail) {
        nameTextView.setText(ownerDetail.getName());
        mailTextView.setText(ownerDetail.getEmail());
        companyTextView.setText(ownerDetail.getCompany());
        crateDateRepoTextView.setText(ownerDetail.getCreatedAt());
        bioTextView.setText(ownerDetail.getBio());
        Picasso.with(getActivity())
                .load(ownerDetail.getAvatarUrl())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(avatarImageView);
    }

    @Override
    public void showError(String error) {
        progressBar.setVisibility(View.GONE);
        errorTextView.setVisibility(View.VISIBLE);
        detailLayout.setVisibility(View.GONE);
        errorTextView.setText(error);
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
        errorTextView.setVisibility(View.GONE);
        detailLayout.setVisibility(View.GONE);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}

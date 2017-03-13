package com.example.alexev.npmtest.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alexev.npmtest.R;
import com.example.alexev.npmtest.activitys.OwnerDetailActivity;
import com.example.alexev.npmtest.fragments.OwnerDetailFragment;
import com.example.alexev.npmtest.model.dto.RepoItem;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class RepoListAdapter extends RecyclerView.Adapter<RepoListAdapter.ViewHolder> {
    private List<RepoItem> repoList;
    private Context context;

    public RepoListAdapter(Context context) {
        this.context = context;
    }

    public void setRepoList(List<RepoItem> repoList) {
        this.repoList = repoList;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.repo_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        RepoItem repo = repoList.get(position);

        setDataToView(holder, repo);
        setOnClickListenerToView(holder, repo);
    }

    private void setOnClickListenerToView(ViewHolder holder, RepoItem repo) {
        int ownerId = repo.getOwner().getId();
        holder.itemView.setTag(ownerId);
        holder.itemView.setOnClickListener(this::clickItem);
    }

    private void setDataToView(ViewHolder holder, RepoItem repo) {
        holder.descriptionTextView.setText(repo.getDescription());
        holder.repoNameTextView.setText(repo.getName());
        holder.ownerNameTextView.setText(repo.getOwner().getLogin());
        Picasso
                .with(context)
                .load(repo.getOwner().getAvatarUrl())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(holder.avatarImageView);
    }

    private void clickItem(View v) {
        int ownerId = (int) v.getTag();
        Intent intent = new Intent(context, OwnerDetailActivity.class);
        intent.putExtra(OwnerDetailFragment.OWNER_ID, ownerId);
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        if (repoList == null) {
            return 0;
        }
        return repoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.repo_list_item_avatar_image_view)
        ImageView avatarImageView;
        @Bind(R.id.repo_list_item_repo_name_text_view)
        TextView repoNameTextView;
        @Bind(R.id.repo_list_item_author_name_text_view)
        TextView ownerNameTextView;
        @Bind(R.id.repo_list_item_description_text_view)
        TextView descriptionTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

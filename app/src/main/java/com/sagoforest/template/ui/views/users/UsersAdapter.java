package com.sagoforest.template.ui.views.users;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.sagoforest.template.dataaccess.entities.User;
import com.sagoforest.template.databinding.UserItemBinding;

import java.util.List;

/**
 * Created by andy on 3/9/18.
 */

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UsersViewHolder> {

    private List<User> mUsers;

    public UsersAdapter(List<User> users) {
        this.mUsers = users;
    }

    @Override
    public UsersAdapter.UsersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        UserItemBinding itemBinding = UserItemBinding.inflate(inflater, parent, false);
        return new UsersViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(UsersViewHolder holder, int position) {
        User user = mUsers.get(position);
        holder.bind(user.toString());
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    public void setUsers(List<User> mUsers) {
        this.mUsers = mUsers;
        notifyDataSetChanged();
    }


    static class UsersViewHolder
            extends RecyclerView.ViewHolder {

        UserItemBinding binding;

        UsersViewHolder(UserItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(String blogPostTitle) {
            binding.userTextView.setText(blogPostTitle);
            binding.executePendingBindings();
        }
    }
}


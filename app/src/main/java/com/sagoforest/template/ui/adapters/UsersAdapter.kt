package com.sagoforest.template.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

import com.sagoforest.template.da.entities.User
import com.sagoforest.template.databinding.UserItemBinding

/**
 * Created by andy on 3/9/18.
 */

class UsersAdapter(private var mUsers: List<User>) : RecyclerView.Adapter<UsersAdapter.UsersViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersAdapter.UsersViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemBinding = UserItemBinding.inflate(inflater, parent, false)
        return UsersViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        val user = mUsers[position]
        holder.bind(user.toString())
    }

    override fun getItemCount(): Int {
        return mUsers.size
    }

    fun setUsers(mUsers: List<User>) {
        this.mUsers = mUsers
        notifyDataSetChanged()
    }


    class UsersViewHolder(private var binding: UserItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(blogPostTitle: String) {
            binding.userTextView.text = blogPostTitle
            binding.executePendingBindings()
        }
    }
}


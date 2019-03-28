package com.sagoforest.template.ui.views.users;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sagoforest.common.ui.views.FragmentBase;
import com.sagoforest.template.R;
import com.sagoforest.template.databinding.FragmentUsersBinding;
import com.sagoforest.template.ui.adapters.UsersAdapter;
import com.sagoforest.template.ui.viewmodels.UsersViewModel;

import javax.inject.Inject;

/**
 * The main fragment
 * <p>
 * Created by andy on 1/30/18.
 */

public class UsersFragment extends FragmentBase {

    @Inject
    ViewModelProvider.Factory factory;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        // get the fragment binding
        FragmentUsersBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_users, container, false);

        // get the AAC VM using the factory
        UsersViewModel vm = ViewModelProviders.of(this, factory).get(UsersViewModel.class);


        UsersAdapter adapter = new UsersAdapter(new java.util.ArrayList<>());


        binding.usersRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.usersRecyclerView.setAdapter(adapter);

        vm.getUsersLiveData().observe(this, adapter::setUsers);

        // bind to the context
        binding.setContext(vm);

        // return the view
        return binding.getRoot();
    }
}




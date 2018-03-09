package com.sagoforest.template.ui.views.newuser;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sagoforest.common.ui.views.FragmentBase;
import com.sagoforest.template.R;
import com.sagoforest.template.databinding.FragmentNewUserBinding;
import com.sagoforest.template.ui.viewmodels.NewUserViewModel;

import javax.inject.Inject;

/**
 * The main fragment
 * <p>
 * Created by andy on 1/30/18.
 */

public class NewUserFragment extends FragmentBase {

    @Inject
    ViewModelProvider.Factory factory;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        // get the fragment binding
        FragmentNewUserBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_new_user, container, false);

        // get the AAC VM using the factory
        NewUserViewModel vm = ViewModelProviders.of(this, factory).get(NewUserViewModel.class);

        // bind to the context
        binding.setContext(vm);

        // return the view
        return binding.getRoot();
    }
}




package com.sagoforest.template.ui.views.mainview;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sagoforest.common.ui.views.FragmentBase;
import com.sagoforest.template.R;
import com.sagoforest.template.databinding.FragmentMainBinding;
import com.sagoforest.template.ui.viewmodels.MainViewModel;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

/**
 * The main fragment
 * <p>
 * Created by andy on 1/30/18.
 */

public class MainFragment extends FragmentBase {

    @Inject
    ViewModelProvider.Factory factory;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        // get the fragment binding
        FragmentMainBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);

        // get the AAC VM using the factory
        MainViewModel vm = ViewModelProviders.of(this, factory).get(MainViewModel.class);

        // bind to the context
        binding.setContext(vm);

        // return the view
        return binding.getRoot();
    }
}




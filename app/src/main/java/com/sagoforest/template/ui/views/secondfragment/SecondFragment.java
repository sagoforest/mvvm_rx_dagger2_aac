package com.sagoforest.template.ui.views.secondfragment;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sagoforest.common.ui.views.FragmentBase;
import com.sagoforest.template.R;
import com.sagoforest.template.databinding.FragmentMainBinding;
import com.sagoforest.template.databinding.FragmentSecondBinding;
import com.sagoforest.template.ui.viewmodels.MainViewModel;
import com.sagoforest.template.ui.viewmodels.SecondViewModel;

import javax.inject.Inject;

/**
 * The main fragment
 * <p>
 * Created by andy on 1/30/18.
 */

public class SecondFragment extends FragmentBase {

    @Inject
    ViewModelProvider.Factory factory;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        // get the fragment binding
        FragmentSecondBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_second, container, false);

        // get the AAC VM using the factory
        SecondViewModel vm = ViewModelProviders.of(this, factory).get(SecondViewModel.class);

        // bind to the context
        binding.setContext(vm);

        // return the view
        return binding.getRoot();
    }
}




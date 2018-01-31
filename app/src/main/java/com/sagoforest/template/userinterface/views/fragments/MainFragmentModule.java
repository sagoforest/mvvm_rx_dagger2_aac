package com.sagoforest.template.userinterface.views.fragments;

import android.arch.lifecycle.ViewModelProvider;

import com.sagoforest.template.userinterface.viewmodels.MainViewModelFactory;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * DI module for the main fragment.
 *
 * Created by andy on 1/30/18.
 */
@Module
public abstract class MainFragmentModule {

    @ContributesAndroidInjector
    abstract MainFragment mainFragment();

    @Binds
    public abstract ViewModelProvider.Factory mainViewModelFactory(MainViewModelFactory factory);
}

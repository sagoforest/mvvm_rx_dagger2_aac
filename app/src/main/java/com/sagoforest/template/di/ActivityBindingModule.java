package com.sagoforest.template.di;

import com.sagoforest.template.userinterface.views.activities.MainActivity;
import com.sagoforest.template.userinterface.views.fragments.MainFragmentModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by andy on 1/30/18.
 */

@Module
public abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = {MainFragmentModule.class})
    abstract MainActivity mainActivity();
}

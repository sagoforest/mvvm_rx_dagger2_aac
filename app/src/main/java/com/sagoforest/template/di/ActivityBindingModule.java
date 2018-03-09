package com.sagoforest.template.di;

import com.sagoforest.common.ui.navigation.INavigationManager;
import com.sagoforest.common.ui.navigation.NavigationManager;
import com.sagoforest.template.ui.views.mainview.MainActivity;
import com.sagoforest.template.ui.views.mainview.MainActivityModule;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by andy on 1/30/18.
 */

@Module
public abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = {MainActivityModule.class})
    abstract MainActivity mainActivity();

    @Binds
    @Singleton
    abstract INavigationManager bindsNavigationManager(NavigationManager navigationManager);
}

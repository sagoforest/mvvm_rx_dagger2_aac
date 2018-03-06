package com.sagoforest.template.di;

import com.sagoforest.common.ui.navigation.INavigationManager;
import com.sagoforest.common.ui.navigation.NavigationManager;
import com.sagoforest.template.ui.views.mainview.MainActivity;
import com.sagoforest.template.ui.views.mainfragment.MainFragmentModule;
import com.sagoforest.template.ui.views.mainview.MainActivityModule;
import com.sagoforest.template.ui.views.secondfragment.SecondFragmentModule;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by andy on 1/30/18.
 */

@Module
public abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = {MainActivityModule.class})
    abstract MainActivity mainActivity();

    @Provides
    @Named("template")
    @Singleton
    static INavigationManager bindsNavigationManager(NavigationManager navigationManager) {
        return navigationManager;
    }
}

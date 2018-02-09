package com.sagoforest.common.ui.views;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * Created by andy on 2/9/18.
 */

@Module
public abstract class ActivityModuleBase {
    static final String ACTIVITY_FRAGMENT_MANAGER = "ActivityModuleBase.activityFragmentManager";


    @Binds
    abstract Context activityContext(Activity activity);

    @Provides
    @Named(ACTIVITY_FRAGMENT_MANAGER)
    static FragmentManager activityFragmentManager(FragmentActivity activity) {
        return activity.getSupportFragmentManager();
    }
}
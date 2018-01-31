package com.sagoforest.template.business;

import android.app.Activity;
import android.app.Application;

import com.sagoforest.template.business.interfaces.ITemplateApp;
import com.sagoforest.template.di.DaggerApplicationComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;

/**
 * The core application
 *
 * Created by andy on 1/30/18.
 */

public class TemplateApp extends Application implements ITemplateApp {

    @Inject
    DispatchingAndroidInjector<Activity> activityInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerApplicationComponent.builder().create(this).inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityInjector;
    }

}

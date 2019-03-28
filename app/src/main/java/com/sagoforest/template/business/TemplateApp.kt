package com.sagoforest.template.business

import android.app.Activity
import android.app.Application

import com.sagoforest.template.business.interfaces.ITemplateApp
import com.sagoforest.template.di.DaggerApplicationComponent

import javax.inject.Inject

import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector

/**
 * The core application
 *
 * Created by andy on 1/30/18.
 */

class TemplateApp : Application(), ITemplateApp {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        DaggerApplicationComponent.builder().create(this).inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityInjector
    }

}

package com.sagoforest.template.di;

import android.app.Application;

import com.sagoforest.template.business.TemplateApp;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

/**
 * The application DI module
 * <p>
 * Created by andy on 1/30/18.
 */

@Module
public abstract class ApplicationModule {

    @Binds
    @Singleton
    abstract Application application(TemplateApp app);

}

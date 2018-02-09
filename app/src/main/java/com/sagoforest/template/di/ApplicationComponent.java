package com.sagoforest.template.di;

import com.sagoforest.template.business.TemplateApp;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

/**
 * Created by andy on 1/30/18.
 */

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        ApplicationModule.class,
        BusinessBindingModule.class,
        ActivityBindingModule.class,
        ViewModelModule.class
})
interface ApplicationComponent extends AndroidInjector<TemplateApp> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<TemplateApp> {
    }


}

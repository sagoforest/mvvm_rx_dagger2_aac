package com.sagoforest.template.di

import com.sagoforest.template.business.TemplateApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

/**
 * Created by andy on 1/30/18.
 */

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    ApplicationModule::class,
    BusinessBindingModule::class,
    ActivityBindingModule::class,
    ViewModelModule::class])
internal interface ApplicationComponent : AndroidInjector<TemplateApp> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<TemplateApp>()


//    @Component.Builder
//    interface Builder {
//        @BindsInstance
//        fun application(application: TemplateApp): Builder
//
//        fun build(): ApplicationComponent
//    }
//
//    override fun inject(app: TemplateApp)
}

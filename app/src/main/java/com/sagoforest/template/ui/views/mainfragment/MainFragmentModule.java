package com.sagoforest.template.ui.views.mainfragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * DI module for the main fragment.
 * <p>
 * Created by andy on 1/30/18.
 */
@Module
public abstract class MainFragmentModule {

    @ContributesAndroidInjector
    abstract MainFragment fragment();

}

package com.sagoforest.template.ui.views.secondfragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * DI module for the main fragment.
 * <p>
 * Created by andy on 1/30/18.
 */
@Module
public abstract class SecondFragmentModule {

    @ContributesAndroidInjector
    abstract SecondFragment fragment();

}

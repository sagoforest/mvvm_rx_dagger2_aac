package com.sagoforest.template.ui.views.mainview;

import android.app.Activity;

import com.sagoforest.template.ui.views.mainfragment.MainFragmentModule;
import com.sagoforest.template.ui.views.secondfragment.SecondFragmentModule;

import dagger.Binds;
import dagger.Module;

/**
 * Created by andy on 2/9/18.
 */

@Module(includes = {
        MainFragmentModule.class,
        SecondFragmentModule.class
})
public abstract class MainActivityModule {

    @Binds
    abstract Activity activity(MainActivity activity);


}

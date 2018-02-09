package com.sagoforest.template.ui.views.mainview;

import android.app.Activity;

import com.sagoforest.common.ui.views.ActivityModuleBase;

import dagger.Binds;
import dagger.Module;

/**
 * Created by andy on 2/9/18.
 */


@Module(includes = {ActivityModuleBase.class,
        MainFragmentModule.class
})
public abstract class MainActivityModule extends ActivityModuleBase {

    @Binds
    abstract Activity activity(MainActivity activity);
}

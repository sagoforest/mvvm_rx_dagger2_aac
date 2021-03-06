package com.sagoforest.template.ui.views.mainview;

import android.app.Activity;

import com.sagoforest.template.ui.views.newuser.NewUserFragmentModule;
import com.sagoforest.template.ui.views.users.UsersFragmentModule;

import dagger.Binds;
import dagger.Module;

/**
 * Created by andy on 2/9/18.
 */

@Module(includes = {
        NewUserFragmentModule.class,
        UsersFragmentModule.class
})
public abstract class MainActivityModule {

    @Binds
    abstract Activity activity(MainActivity activity);


}

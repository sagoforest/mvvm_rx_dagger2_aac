package com.sagoforest.template.ui.views.users;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * DI module for the main fragment.
 * <p>
 * Created by andy on 1/30/18.
 */
@Module
public abstract class UsersFragmentModule {

    @ContributesAndroidInjector
    abstract UsersFragment fragment();

}

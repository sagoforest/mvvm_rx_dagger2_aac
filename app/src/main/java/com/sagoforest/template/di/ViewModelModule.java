package com.sagoforest.template.di;


import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.sagoforest.common.ui.viewmodels.ViewModelFactoryProvider;
import com.sagoforest.common.ui.viewmodels.ViewModelKey;
import com.sagoforest.template.ui.viewmodels.NewUserViewModel;
import com.sagoforest.template.ui.viewmodels.UsersViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
abstract class ViewModelModule {


    @Binds
    @IntoMap
    @ViewModelKey(NewUserViewModel.class)
    abstract ViewModel bindNewUserViewModel(NewUserViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(UsersViewModel.class)
    abstract ViewModel bindUsersViewModel(UsersViewModel viewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactoryProvider factory);
}
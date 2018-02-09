package com.sagoforest.template.di;


import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.sagoforest.common.ui.viewmodels.ViewModelFactoryProvider;
import com.sagoforest.common.ui.viewmodels.ViewModelKey;
import com.sagoforest.template.ui.viewmodels.MainViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
abstract class ViewModelModule {


    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.class)
    abstract ViewModel bindMainViewModel(MainViewModel viewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactoryProvider factory);
}
package com.sagoforest.template.di


import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

import com.sagoforest.common.ui.viewmodels.ViewModelFactoryProvider
import com.sagoforest.common.ui.viewmodels.ViewModelKey
import com.sagoforest.template.ui.viewmodels.NewUserViewModel
import com.sagoforest.template.ui.viewmodels.UsersViewModel

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(NewUserViewModel::class)
    internal abstract fun bindNewUserViewModel(viewModel: NewUserViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(UsersViewModel::class)
    internal abstract fun bindUsersViewModel(viewModel: UsersViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactoryProvider): ViewModelProvider.Factory
}
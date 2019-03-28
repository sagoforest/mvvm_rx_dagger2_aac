package com.sagoforest.template.di

import com.sagoforest.template.business.interfaces.usecases.IUsersUseCase
import com.sagoforest.template.business.usecases.UsersUseCase

import dagger.Binds
import dagger.Module

/**
 * Created by andy on 1/30/18.
 */
@Module
internal abstract class BusinessBindingModule {
    @Binds
    internal abstract fun bindUsersUseCase(useCase: UsersUseCase): IUsersUseCase
}

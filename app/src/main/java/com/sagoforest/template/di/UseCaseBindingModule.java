package com.sagoforest.template.di;

import com.sagoforest.template.business.interfaces.usecases.IRandomNameUseCase;
import com.sagoforest.template.business.usecases.RandomNameUseCase;

import dagger.Binds;
import dagger.Module;

/**
 * Created by andy on 1/30/18.
 */
@Module
public abstract class UseCaseBindingModule {
    @Binds
    public abstract IRandomNameUseCase provideRandomNameUseCase(RandomNameUseCase useCase);
}

package com.sagoforest.template.ui.viewmodels;

import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.sagoforest.template.business.interfaces.usecases.IRandomNameUseCase;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by andy on 1/30/18.
 */

@Singleton
public class MainViewModelFactory implements ViewModelProvider.Factory {

    private IRandomNameUseCase mUseCase;

    @Inject
    public MainViewModelFactory(@NonNull IRandomNameUseCase useCase) {
        mUseCase = useCase;
    }

    @NonNull
    @Override
    public MainViewModel create(Class modelClass) {
        return new MainViewModel(mUseCase);
    }
}

package com.sagoforest.template.userinterface.viewmodels;

import android.arch.lifecycle.ViewModel;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by andy on 1/30/18.
 */

public class ViewModelBase extends ViewModel {

    private CompositeDisposable mCompositeSubscription = new CompositeDisposable();

    protected void addSubscription(Disposable disposable) {
        mCompositeSubscription.add(disposable);
    }

    @Override
    protected void onCleared() {
        // clear all subscriptions
        mCompositeSubscription.clear();
        // call super
        super.onCleared();
    }
}

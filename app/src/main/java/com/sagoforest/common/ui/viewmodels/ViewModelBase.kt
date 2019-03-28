package com.sagoforest.common.ui.viewmodels

import android.arch.lifecycle.ViewModel

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by andy on 1/30/18.
 */

open class ViewModelBase : ViewModel() {

    private val mCompositeSubscription = CompositeDisposable()

    protected fun addSubscription(disposable: Disposable) {
        mCompositeSubscription.add(disposable)
    }

    override fun onCleared() {
        // clear all subscriptions
        mCompositeSubscription.clear()
        // call super
        super.onCleared()
    }
}


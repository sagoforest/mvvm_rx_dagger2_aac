package com.sagoforest.common.ui.views

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import com.sagoforest.common.ui.navigation.INavigationManager
import com.sagoforest.common.ui.navigation.INavigationPage
import com.sagoforest.common.ui.rx.SchedulerFacade
import io.reactivex.disposables.CompositeDisposable


/**
 * A base navigation controller that is lifecycle aware
 *
 *
 * Created by andy on 2/23/18.
 */


abstract class NavigationControllerBase(protected val mNavigationManager: INavigationManager) : LifecycleObserver {
    private val disposables = CompositeDisposable()

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun connectListener() {
        // listen for navigation changes
        disposables.add(mNavigationManager.currentPage
                .subscribeOn(SchedulerFacade.computation())
                .observeOn(SchedulerFacade.ui())
                .subscribe({ this.switchPage(it) }))
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun disconnectListener() {
        disposables.clear()
    }

    protected abstract fun switchPage(page: INavigationPage)
}


package com.sagoforest.common.ui.views;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.support.annotation.NonNull;

import com.sagoforest.common.ui.navigation.INavigationManager;
import com.sagoforest.common.ui.navigation.INavigationPage;
import com.sagoforest.common.ui.rx.SchedulerFacade;

import io.reactivex.disposables.CompositeDisposable;


/**
 * A base navigation controller that is lifecycle aware
 * <p>
 * Created by andy on 2/23/18.
 */


public abstract class NavigationControllerBase implements LifecycleObserver {
    protected final INavigationManager mNavigationManager;
    private final CompositeDisposable disposables = new CompositeDisposable();

    public NavigationControllerBase(@NonNull INavigationManager navigationManager) {

        mNavigationManager = navigationManager;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void connectListener() {
        // listen for navigation changes
        disposables.add(mNavigationManager.getCurrentPage()
                .subscribeOn(SchedulerFacade.computation())
                .observeOn(SchedulerFacade.ui())
                .subscribe(this::switchPage));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void disconnectListener() {
        disposables.clear();
    }

    protected abstract void switchPage(INavigationPage page);
}


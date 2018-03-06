package com.sagoforest.common.ui.rx;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * A wrapper for the various schedulers used in RxAndroid.
 * <p>
 * Created by jeff.picklyk on 1/23/18.
 */

public class SchedulerFacade {


    /**
     * IO thread pool scheduler
     */
    public static Scheduler io() {
        return Schedulers.io();
    }

    /**
     * Computation thread pool scheduler
     */
    public static Scheduler computation() {
        return Schedulers.computation();
    }

    /**
     * Main Thread scheduler
     */
    public static Scheduler ui() {
        return AndroidSchedulers.mainThread();
    }
}

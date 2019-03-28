package com.sagoforest.common.ui.rx

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * A wrapper for the various schedulers used in RxAndroid.
 *
 *
 * Created by jeff.picklyk on 1/23/18.
 */

object SchedulerFacade {

    /**
     * IO thread pool scheduler
     */
    fun io(): Scheduler {
        return Schedulers.io()
    }

    /**
     * Computation thread pool scheduler
     */
    fun computation(): Scheduler {
        return Schedulers.computation()
    }

    /**
     * Main Thread scheduler
     */
    fun ui(): Scheduler {
        return AndroidSchedulers.mainThread()
    }
}

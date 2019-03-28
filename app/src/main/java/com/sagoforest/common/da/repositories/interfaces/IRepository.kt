package com.sagoforest.common.da.repositories.interfaces

import io.reactivex.Completable
import io.reactivex.Flowable

/**
 * Created by andy on 3/9/18.
 */

interface IRepository<T> {
    val all: Flowable<List<T>>

    fun getItem(id: Int): Flowable<T>

    fun add(item: T): Completable

    fun update(item: T): Completable

    fun remove(id: Int): Completable

}

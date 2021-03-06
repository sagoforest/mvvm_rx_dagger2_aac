package com.sagoforest.common.da.repositories.interfaces;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;

/**
 * Created by andy on 3/9/18.
 */

public interface IRepository<T> {
    Flowable<List<T>> getAll();

    Flowable<T> getItem(int id);

    Completable add(T item);

    Completable update(T item);

    Completable remove(int id);

}

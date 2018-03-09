package com.sagoforest.common.dataaccess.repositories.interfaces;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by andy on 3/9/18.
 */

public interface IRepository<T> {
    Flowable<List<T>> getAll();

    Flowable<T> getItem(int id);

    void add(T item);

    void update(T item);

    void remove(int id);

}

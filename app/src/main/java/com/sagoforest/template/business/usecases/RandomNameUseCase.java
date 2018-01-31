package com.sagoforest.template.business.usecases;


import com.sagoforest.template.business.interfaces.usecases.IRandomNameUseCase;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

/**
 * Concrete implementation of the random name use case
 *
 * Created by andy on 1/30/18.
 */

@Singleton
public class RandomNameUseCase implements IRandomNameUseCase {

    private final PublishSubject<String> mRandomName = PublishSubject.create();


    @Inject
    public RandomNameUseCase() {
    }

    public void generateRandomName() {
        double seed = Math.random();
        int index = (int) (seed * 100);
        mRandomName.onNext(String.valueOf(index));

    }

    public Observable<String> getName() {
        return mRandomName;
    }
}

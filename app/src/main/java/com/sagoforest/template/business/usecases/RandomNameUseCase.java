package com.sagoforest.template.business.usecases;


import android.support.annotation.NonNull;

import com.sagoforest.template.business.interfaces.usecases.IRandomNameUseCase;
import com.sagoforest.template.dataaccess.UsersDatabase;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

/**
 * Concrete implementation of the random name use case
 * <p>
 * Created by andy on 1/30/18.
 */

@Singleton
public class RandomNameUseCase implements IRandomNameUseCase {

    private final PublishSubject<String> mRandomName = PublishSubject.create();
    private UsersDatabase mUsersDatabase;

    @Inject
    public RandomNameUseCase(@NonNull UsersDatabase usersDatabase) {
        mUsersDatabase = usersDatabase;
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

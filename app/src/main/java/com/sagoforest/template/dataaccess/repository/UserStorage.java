package com.sagoforest.template.dataaccess.repository;

import android.support.annotation.NonNull;

import com.sagoforest.template.dataaccess.User;
import com.sagoforest.template.dataaccess.UsersDatabase;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by andy on 3/7/18.
 */

@Singleton
public class UserStorage {

    private UsersDatabase mDatabase;

    @Inject
    public UserStorage(@NonNull UsersDatabase database) {
        mDatabase = database;
    }


    public void addUser(User user) {
        Observable.just(mDatabase)
                .subscribeOn(Schedulers.io())
                .subscribe(usersDatabase -> mDatabase.userDao().insert(user));
    }
}

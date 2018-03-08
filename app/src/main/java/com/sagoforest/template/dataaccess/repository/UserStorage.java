package com.sagoforest.template.dataaccess.repository;

import android.support.annotation.NonNull;

import com.sagoforest.common.ui.rx.SchedulerFacade;
import com.sagoforest.template.dataaccess.User;
import com.sagoforest.template.dataaccess.UsersDatabase;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;
import io.reactivex.Observable;

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
                .subscribeOn(SchedulerFacade.io())
                .subscribe(usersDatabase -> usersDatabase.userDao().insert(user));
    }

    public Flowable<List<User>> getUsers() {
        return mDatabase.userDao().getAll();
    //   return Flowable.create(emitter -> { mDatabase.userDao().getAll()});
//        return Observable.just(mDatabase)
//                .subscribeOn(SchedulerFacade.io())
//                .doOnNext(usersDatabase -> usersDatabase.userDao().getAll());
    }
}

package com.sagoforest.template.dataaccess.repository;

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
public class UserRepository {


    private UsersDatabase mDatabase;

    @Inject
    public UserRepository(@android.support.annotation.NonNull UsersDatabase database) {
        mDatabase = database;
    }

    public void addUser(User user) {
        Observable.just(mDatabase)
                .subscribeOn(SchedulerFacade.io())
                .subscribe(usersDatabase -> usersDatabase.userDao().insert(user));
    }

    public Flowable<List<User>> getUsers() {
        return mDatabase.userDao().getAll();
    }
}

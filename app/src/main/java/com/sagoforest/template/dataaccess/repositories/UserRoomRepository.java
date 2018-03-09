package com.sagoforest.template.dataaccess.repositories;

import android.support.annotation.NonNull;

import com.sagoforest.common.ui.rx.SchedulerFacade;
import com.sagoforest.template.dataaccess.databases.TemplateDatabase;
import com.sagoforest.template.dataaccess.entities.User;
import com.sagoforest.template.dataaccess.interfaces.repositories.IUserRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.Observable;

/**
 * Created by andy on 3/7/18.
 */

public class UserRoomRepository implements IUserRepository {


    private TemplateDatabase mDatabase;

    @Inject
    public UserRoomRepository(@NonNull TemplateDatabase database) {
        mDatabase = database;
    }

    @Override
    public Flowable<List<User>> getAll() {
        return mDatabase.userDao().getAll();
    }

    @Override
    public Flowable<User> getItem(int id) {
        return null;
    }

    @Override
    public void add(User item) {
        Observable.just(mDatabase)
                .subscribeOn(SchedulerFacade.io())
                .subscribe(usersDatabase -> usersDatabase.userDao().insert(item));
    }

    @Override
    public void update(User item) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public void removeAll() {
        Observable.just(mDatabase)
                .subscribeOn(SchedulerFacade.io())
                .subscribe(usersDatabase -> usersDatabase.userDao().removeAll());
    }
}

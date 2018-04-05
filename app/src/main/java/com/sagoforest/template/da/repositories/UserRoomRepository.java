package com.sagoforest.template.da.repositories;

import com.sagoforest.common.ui.rx.SchedulerFacade;
import com.sagoforest.template.da.databases.TemplateDatabase;
import com.sagoforest.template.da.entities.User;
import com.sagoforest.template.da.interfaces.dao.UserDao;
import com.sagoforest.template.da.interfaces.repositories.IUserRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import lombok.NonNull;

/**
 * Created by andy on 3/7/18.
 */

public class UserRoomRepository implements IUserRepository {


    private UserDao mUserDao;

    @Inject
    public UserRoomRepository(@NonNull TemplateDatabase database) {
        mUserDao = database.userDao();
    }

    @Override
    public Flowable<List<User>> getAll() {
        return mUserDao.getAll();
    }

    @Override
    public Flowable<User> getItem(int id) {
        return null;
    }

    @Override
    public Completable add(User item) {
        return Completable.fromAction(() -> mUserDao.insert(item))
                .subscribeOn(SchedulerFacade.io());
    }

    @Override
    public Completable update(User item) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Completable remove(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Completable removeAll() {
        return Completable.fromAction(() -> mUserDao.removeAll())
                .subscribeOn(SchedulerFacade.io());
    }
}

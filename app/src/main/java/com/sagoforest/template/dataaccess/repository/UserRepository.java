package com.sagoforest.template.dataaccess.repository;

import com.sagoforest.template.dataaccess.User;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.annotations.NonNull;

/**
 * Created by andy on 3/7/18.
 */

@Singleton
public class UserRepository {
    private UserStorage mStorage;

    @Inject
    public UserRepository(@NonNull UserStorage storage) {
        mStorage = storage;
    }

    public void addUser(User user) {
        mStorage.addUser(user);
    }
}

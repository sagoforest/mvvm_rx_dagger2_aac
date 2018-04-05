package com.sagoforest.template.business.usecases;


import com.sagoforest.template.business.interfaces.usecases.IUsersUseCase;
import com.sagoforest.template.da.entities.User;
import com.sagoforest.template.da.interfaces.repositories.IUserRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;
import lombok.NonNull;

/**
 * Use case than manages users
 * <p>
 * Created by andy on 1/30/18.
 */

@Singleton
public class UsersUseCase implements IUsersUseCase {


    private IUserRepository mRepository;

    @Inject
    public UsersUseCase(@NonNull IUserRepository repository) {
        mRepository = repository;
    }


    @Override
    public Flowable<List<User>> getUsers() {
        return mRepository.getAll();
    }

    @Override
    public void addNew(String firstName, String lastName) {
        mRepository.add(new User(firstName, lastName)).subscribe(() -> {
            // on success
        }, throwable -> {
            // on error
        });
    }

    @Override
    public void clearAll() {
        mRepository.removeAll();
    }
}

package com.sagoforest.template.business.interfaces.usecases;

import com.sagoforest.template.dataaccess.entities.User;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Contract for the random name use case.
 * <p>
 * Created by andy on 1/30/18.
 */

public interface IUsersUseCase {

    Flowable<List<User>> getUsers();

    void addNew(String firstName, String lastName);

    void clearAll();
}

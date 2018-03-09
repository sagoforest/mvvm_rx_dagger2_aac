package com.sagoforest.template.dataaccess.interfaces.repositories;

import com.sagoforest.common.dataaccess.repositories.interfaces.IRepository;
import com.sagoforest.template.dataaccess.entities.User;

/**
 * Created by andy on 3/9/18.
 */

public interface IUserRepository extends IRepository<User> {
    void removeAll();
}

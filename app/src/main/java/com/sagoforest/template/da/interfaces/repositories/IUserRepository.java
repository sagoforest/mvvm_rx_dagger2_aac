package com.sagoforest.template.da.interfaces.repositories;

import com.sagoforest.common.da.repositories.interfaces.IRepository;
import com.sagoforest.template.da.entities.User;

/**
 * Created by andy on 3/9/18.
 */

public interface IUserRepository extends IRepository<User> {
    void removeAll();
}

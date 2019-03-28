package com.sagoforest.template.business.interfaces.usecases

import com.sagoforest.template.da.entities.User

import io.reactivex.Flowable

/**
 * Use case that manages users
 *
 *
 * Created by andy on 1/30/18.
 */

interface IUsersUseCase {

    val users: Flowable<List<User>>

    fun addNew(firstName: String, lastName: String)

    fun clearAll()
}

package com.sagoforest.template.da.repositories

import com.sagoforest.common.ui.rx.SchedulerFacade
import com.sagoforest.template.da.databases.TemplateDatabase
import com.sagoforest.template.da.entities.User
import com.sagoforest.template.da.interfaces.dao.UserDao
import com.sagoforest.template.da.interfaces.repositories.IUserRepository
import io.reactivex.Completable
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created by andy on 3/7/18.
 */

class UserRoomRepository

@Inject
constructor(database: TemplateDatabase) : IUserRepository {


    private val mUserDao: UserDao = database.userDao()

    override val all: Flowable<List<User>>
        get() = mUserDao.getAll()

    override fun getItem(id: Int): Flowable<User> {
        return  mUserDao.findById(id)
    }

    override fun add(item: User): Completable {
        return Completable.fromAction { mUserDao.insert(item) }
                .subscribeOn(SchedulerFacade.io())
    }

    override fun update(item: User): Completable {
        throw UnsupportedOperationException()
    }

    override fun remove(id: Int): Completable {
        throw UnsupportedOperationException()
    }

    override fun removeAll(): Completable {
        return Completable.fromAction { mUserDao.removeAll() }
                .subscribeOn(SchedulerFacade.io())
    }
}

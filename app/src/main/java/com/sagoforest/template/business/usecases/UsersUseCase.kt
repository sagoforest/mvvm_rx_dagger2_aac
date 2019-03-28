package com.sagoforest.template.business.usecases


import android.util.Log
import com.sagoforest.template.business.interfaces.usecases.IUsersUseCase
import com.sagoforest.template.da.entities.User
import com.sagoforest.template.da.interfaces.repositories.IUserRepository
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Use case than manages users
 *
 *
 * Created by andy on 1/30/18.
 */

@Singleton
class UsersUseCase
@Inject constructor(private val mRepository: IUserRepository) : IUsersUseCase {


    override val users: Flowable<List<User>>
        get() = mRepository.all

    override fun addNew(firstName: String, lastName: String) {
        mRepository.add(User(firstName, lastName))
                .subscribe({ Log.d(TAG, "added user") },
                        { Log.d(TAG, "failed to add user") })
    }

    override fun clearAll() {
        mRepository.removeAll()
    }

    companion object {
        private val TAG = UsersUseCase::class.java.simpleName
    }
}

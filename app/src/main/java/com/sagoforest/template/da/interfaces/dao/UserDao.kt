package com.sagoforest.template.da.interfaces.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

import com.sagoforest.template.da.entities.User

import io.reactivex.Flowable

/**
 * Created by andy on 3/7/18.
 */

@Dao
interface UserDao {

    @Query("SELECT * FROM users")
    fun getAll(): Flowable<List<User>>

    @Query("SELECT * FROM users WHERE id IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<User>

    @Query("SELECT * FROM users WHERE first_name LIKE :first AND " + "last_name LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): User

    @Query("SELECT * FROM users WHERE id = :id")
    fun findById(id: Int): Flowable<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User)

    @Delete
    fun delete(user: User)

    @Query("DELETE FROM users")
    fun removeAll()
}

package com.sagoforest.template.dataaccess;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by andy on 3/7/18.
 */

@Database(entities = {User.class}, version = UsersDatabase.VERSION, exportSchema = false)
public abstract class UsersDatabase extends RoomDatabase {

    static final int VERSION = 1;

    public abstract UserDao userDao();
}


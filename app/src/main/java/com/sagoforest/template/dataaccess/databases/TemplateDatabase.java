package com.sagoforest.template.dataaccess.databases;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.sagoforest.template.dataaccess.entities.User;
import com.sagoforest.template.dataaccess.interfaces.dao.UserDao;

/**
 * Created by andy on 3/7/18.
 */

@Database(entities = {User.class}, version = TemplateDatabase.VERSION, exportSchema = false)
public abstract class TemplateDatabase extends RoomDatabase {

    static final int VERSION = 1;

    public abstract UserDao userDao();
}


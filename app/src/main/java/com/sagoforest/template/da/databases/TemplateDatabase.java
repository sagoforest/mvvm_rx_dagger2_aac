package com.sagoforest.template.da.databases;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.sagoforest.template.da.entities.User;
import com.sagoforest.template.da.interfaces.dao.UserDao;

/**
 * Created by andy on 3/7/18.
 */

@Database(entities = {User.class}, version = TemplateDatabase.VERSION, exportSchema = false)
public abstract class TemplateDatabase extends RoomDatabase {

    static final int VERSION = 1;

    public abstract UserDao userDao();
}


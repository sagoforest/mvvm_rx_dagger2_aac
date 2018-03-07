package com.sagoforest.template.di;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.sagoforest.template.dataaccess.UsersDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by andy on 3/7/18.
 */
@Module
public abstract class DataAccessModule {

    @Provides
    @Singleton
    static UsersDatabase providesRoomDatabase(Application application) {
        return Room.databaseBuilder(application, UsersDatabase.class, "users-db").build();
    }
}

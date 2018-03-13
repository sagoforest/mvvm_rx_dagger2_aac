package com.sagoforest.template.di;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.sagoforest.template.business.TemplateApp;
import com.sagoforest.template.da.databases.TemplateDatabase;
import com.sagoforest.template.da.interfaces.repositories.IUserRepository;
import com.sagoforest.template.da.repositories.UserRoomRepository;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * The application DI module
 * <p>
 * Created by andy on 1/30/18.
 */

@Module
public abstract class ApplicationModule {

    private static final String DATABASE_FILENAME = "template-db";

    @Binds
    @Singleton
    abstract Application application(TemplateApp app);


    @Provides
    @Singleton
    static TemplateDatabase providesRoomDatabase(Application application) {
        return Room.databaseBuilder(application, TemplateDatabase.class, DATABASE_FILENAME).build();
    }

    @Binds
    @Singleton
    abstract IUserRepository userRepository(UserRoomRepository repository);

}

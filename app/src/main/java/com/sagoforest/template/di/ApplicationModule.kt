package com.sagoforest.template.di

import android.app.Application
import android.arch.persistence.room.Room
import com.sagoforest.template.business.TemplateApp
import com.sagoforest.template.da.databases.TemplateDatabase
import com.sagoforest.template.da.interfaces.repositories.IUserRepository
import com.sagoforest.template.da.repositories.UserRoomRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * The application DI module
 *
 *
 * Created by andy on 1/30/18.
 */

@Module
internal abstract class ApplicationModule {

    @Binds
    @Singleton
    internal abstract fun application(app: TemplateApp): Application

    @Binds
    @Singleton
    internal abstract fun userRepository(repository: UserRoomRepository): IUserRepository


    @Module
    companion object {
        private const val DATABASE_FILENAME = "template-db"

        @JvmStatic
        @Provides
        @Singleton
        fun providesRoomDatabase(application: Application): TemplateDatabase =
                Room.databaseBuilder(application, TemplateDatabase::class.java, DATABASE_FILENAME)
                        .fallbackToDestructiveMigration()
                        .build()
    }
}

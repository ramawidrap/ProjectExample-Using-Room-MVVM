package com.example.roomexample.dagger

import android.app.Application
import androidx.room.Room
import com.example.roomexample.db.ContactDao
import com.example.roomexample.db.ContactDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {
    @Singleton
    @Provides
    fun provideContactDatabase(application : Application) : ContactDatabase {
        return Room.databaseBuilder(
            application.applicationContext,
            ContactDatabase::class.java,
            "contactDB"
        ).build()
    }

    @Singleton
    @Provides
    fun provideContactDao(database : ContactDatabase) : ContactDao {
        return database.contactDao()
    }

}
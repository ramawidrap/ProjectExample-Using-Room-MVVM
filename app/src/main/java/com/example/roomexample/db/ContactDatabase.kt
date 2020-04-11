package com.example.roomexample.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomexample.db.entity.Contact

@Database(entities = [Contact::class],version = 1)
abstract class ContactDatabase : RoomDatabase() {
    abstract fun contactDao() : ContactDao

    companion object {
        private var INSTANCE : ContactDatabase? = null

        fun getInstance(context : Context) : ContactDatabase {
            if(INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    ContactDatabase::class.java,
                    "contactDB"
                ).build()
            }
            return INSTANCE!!
        }
    }

}
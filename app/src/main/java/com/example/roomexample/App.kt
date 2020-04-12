package com.example.roomexample

import android.app.Application
import android.util.Log
import com.example.roomexample.dagger.ApplicationComponent
import com.example.roomexample.dagger.ApplicationModule
import com.example.roomexample.dagger.DaggerApplicationComponent
import com.example.roomexample.dagger.RoomModule
import com.example.roomexample.db.ContactDatabase
import dagger.android.DaggerApplication
import javax.inject.Inject

class App : Application() {
    lateinit var appComponent : ApplicationComponent

    companion object {
        lateinit var app : App
    }



    @Inject
    lateinit var db : ContactDatabase


    override fun onCreate() {
        super.onCreate()
        Log.i("init_app","test")
        app = this

        appComponent=DaggerApplicationComponent.builder().applicationModule(ApplicationModule(this)).roomModule(
            RoomModule()
        ).build()
        Log.i("init_app","finish build")


    }

    fun getApplicationComponent() : ApplicationComponent {
        return appComponent
    }

}
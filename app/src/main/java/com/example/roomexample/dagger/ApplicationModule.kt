package com.example.roomexample.dagger

import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.roomexample.MainActivity
import com.example.roomexample.db.ContactDao
import com.example.roomexample.db.ContactDatabase
import com.example.roomexample.db.entity.Contact
import com.example.roomexample.repository.viewmodel.ContactViewModel
import com.example.roomexample.repository.viewmodel.ContactViewModelFactory
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class ApplicationModule(val application: Application) {


    @Singleton
    @Provides
    fun provideApplication() : Application {
        return application
    }


}

@Singleton
@Component(modules = [ApplicationModule::class,RoomModule::class,MainActivityModule::class])
interface ApplicationComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(app : Application)
}
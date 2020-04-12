package com.example.roomexample.dagger

import androidx.lifecycle.ViewModelProvider
import com.example.roomexample.MainActivity
import com.example.roomexample.db.entity.Contact
import com.example.roomexample.repository.viewmodel.ContactViewModel
import com.example.roomexample.repository.viewmodel.ContactViewModelFactory
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class MainActivityModule {

    @Binds
    abstract fun getContactViewModelFactory(contactViewModelFactory: ContactViewModelFactory) : ViewModelProvider.Factory
}





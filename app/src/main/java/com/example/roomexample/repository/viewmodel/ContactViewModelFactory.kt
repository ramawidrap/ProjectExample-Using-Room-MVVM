package com.example.roomexample.repository.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

    class ContactViewModelFactory @Inject constructor(val contactViewModel : Provider<ContactViewModel>) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return contactViewModel.get() as T
    }
}
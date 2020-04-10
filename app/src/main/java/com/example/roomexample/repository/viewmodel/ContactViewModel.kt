package com.example.roomexample.repository.viewmodel

import android.app.Application
import androidx.annotation.NonNull
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.roomexample.db.entity.Contact
import com.example.roomexample.repository.ContactRepository

class ContactViewModel(@NonNull application: Application) : AndroidViewModel(application){



    private val  contactRepository = ContactRepository(application)


    fun getAllContact() : LiveData<List<Contact>> {
        return contactRepository.getAllContactLiveData()
    }

    fun createContact() {
        contactRepository.createContact()
    }

    fun deleteContact(contact: Contact) {
        contactRepository.deleteContact(contact)
    }

    fun clear() {
        contactRepository.clear()
    }
}
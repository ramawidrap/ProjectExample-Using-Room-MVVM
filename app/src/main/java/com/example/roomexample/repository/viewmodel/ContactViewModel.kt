package com.example.roomexample.repository.viewmodel

import android.app.Application
import androidx.annotation.NonNull
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.roomexample.db.entity.Contact
import com.example.roomexample.repository.ContactRepository
import javax.inject.Inject

class ContactViewModel @Inject constructor(val contactRepository: ContactRepository) : ViewModel() {







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
package com.example.roomexample.repository

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import com.example.roomexample.db.ContactDatabase
import com.example.roomexample.db.entity.Contact
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.schedulers.Schedulers

class ContactRepository(private val application: Application) {
    private val db: ContactDatabase = ContactDatabase.getInstance(application)

    private val dispose = CompositeDisposable()
    private val listContact = MutableLiveData<List<Contact>>()

    init {
        getAllContact()
    }




    fun createContact() {
        dispose.add(Completable.fromAction {
            db.contactDao().insertContact(Contact("RAmbo", "wkwkw@ui.ac.id", 0))
        }.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribeWith(
            object : DisposableCompletableObserver() {
                override fun onComplete() {
                    Toast.makeText(
                        application.applicationContext,
                        "Success create contact",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onError(e: Throwable) {
                    Toast.makeText(
                        application.applicationContext,
                        "Failed create contact",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }))
    }


    fun clear() {
        dispose.clear()
    }

    fun deleteContact(contact: Contact) {
        dispose.add(Completable.fromAction {
            db.contactDao().deleteContact(contact)
        }.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribeWith(
            object : DisposableCompletableObserver() {
                override fun onComplete() {
                    Toast.makeText(
                        application.applicationContext,
                        "Success Delete Contact",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onError(e: Throwable) {
                    Toast.makeText(
                        application.applicationContext,
                        "Failed Delete Contact",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }))
    }

    fun getAllContact() {
        dispose.add(
            db.contactDao().getAll().subscribeOn(Schedulers.computation()).observeOn(
                AndroidSchedulers.mainThread()
            ).subscribe {
                listContact.postValue(it)

                Consumer<Throwable> {
                    Toast.makeText(application.applicationContext,it.message,Toast.LENGTH_SHORT).show()
                }
            })
    }

    fun getAllContactLiveData() : MutableLiveData<List<Contact>> {
        return listContact
    }

}
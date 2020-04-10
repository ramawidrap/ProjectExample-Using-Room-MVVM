package com.example.roomexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.roomexample.adapter.ContactAdapter
import com.example.roomexample.db.ContactDatabase
import com.example.roomexample.db.entity.Contact
import com.example.roomexample.repository.viewmodel.ContactViewModel
import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.observers.DisposableObserver

import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import java.util.Observer


class MainActivity : AppCompatActivity() {

    private lateinit var contactAdapter : ContactAdapter

    private var listContact : MutableList<Contact> = mutableListOf()

    private lateinit var layoutManager : RecyclerView.LayoutManager



    private lateinit var contactViewModel : ContactViewModel




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        contactViewModel = ViewModelProvider(this).get(ContactViewModel::class.java)


        contactAdapter = ContactAdapter(listContact,contactViewModel)
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = contactAdapter


        contactViewModel.getAllContact().observe(this, androidx.lifecycle.Observer{
            listContact.clear()
            listContact.addAll(it)
            contactAdapter.notifyDataSetChanged()

        })

        addContact.setOnClickListener {
            contactViewModel.createContact()
        }





    }




    override fun onResume() {
        super.onResume()
//        db.contactDao().insertContact(Contact("rama","rama.widragama@ui.ac.id",0))
//        db.contactDao().insertContact(Contact("rambo","rambo.widragama@ui.ac.id",0))
//        db.contactDao().insertContact(Contact("rambo","ramboy.widragama@ui.ac.id",0))
    }

    override fun onDestroy() {
        super.onDestroy()
        contactViewModel.clear()
    }
}

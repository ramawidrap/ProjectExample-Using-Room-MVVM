package com.example.roomexample.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.roomexample.R
import com.example.roomexample.db.ContactDatabase
import com.example.roomexample.db.entity.Contact
import com.example.roomexample.repository.viewmodel.ContactViewModel
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.schedulers.Schedulers

class ContactAdapter(private val listContact : List<Contact>,private val contactViewModel: ContactViewModel) :
    RecyclerView.Adapter<ContactAdapter.MyViewHolder>() {




    class MyViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val name = v.findViewById<TextView>(R.id.name)
        val email = v.findViewById<TextView>(R.id.email)
        val remove = v.findViewById<Button>(R.id.removeButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_list_item,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listContact.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.name.text = listContact[position].name
        holder.email.text = listContact[position].email

        holder.remove.setOnClickListener {
            contactViewModel.deleteContact(listContact[position])
        }
    }

//    fun deleteContact() {
//        dispose.add(Completable.fromAction {
//            db.contactDao().deleteContact()Contact(Contact("RAmbo","wkwkw@ui.ac.id",0))
//        }.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribeWith(object : DisposableCompletableObserver(){
//            override fun onComplete() {
//                Toast.makeText(applicationContext,"Success create contact", Toast.LENGTH_SHORT).show()
//            }
//
//            override fun onError(e: Throwable) {
//                Toast.makeText(applicationContext,"Failed create contact", Toast.LENGTH_SHORT).show()
//            }
//
//        }))
//    }
}
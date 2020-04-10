package com.example.roomexample.db

import androidx.room.*
import com.example.roomexample.db.entity.Contact
import io.reactivex.Flowable

@Dao
interface ContactDao {

    @Insert
    fun insertContact(contact: Contact)

    @Update
    fun updateContact(contact: Contact)

    @Delete
    fun deleteContact(contact: Contact)

    @Query("select * from contact where id == :contact_id")
    fun getContact(contact_id : Int) : Flowable<Contact>

    @Query("select * from contact")
    fun getAll() : Flowable<List<Contact>>

}
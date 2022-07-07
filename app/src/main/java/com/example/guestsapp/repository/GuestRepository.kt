package com.example.guestsapp.repository

import android.content.ContentValues
import android.content.Context
import com.example.guestsapp.Contants.DataBaseConstants
import com.example.guestsapp.Model.GuestModel
import kotlinx.coroutines.selects.select
import java.lang.Exception

class GuestRepository private constructor(context: Context) {

    private val guestDataBase = GuestDataBase(context)

    companion object {
        private lateinit var repository: GuestRepository

        fun getInstance(context: Context): GuestRepository {
            if(!Companion::repository.isInitialized) {
                repository = GuestRepository(context)
            }
            return repository
        }
    }

    fun insert(guest: GuestModel): Boolean {
        return try {
            val db = guestDataBase.writableDatabase

            val presence = if (guest.presence) 1 else 0

            val values = ContentValues()
            values.put( DataBaseConstants.GUEST.COLUMNS.NAME, guest.name)
            values.put( DataBaseConstants.GUEST.COLUMNS.PRESENCE, presence)

            db.insert(DataBaseConstants.GUEST.TABLE_NAME, null, values)
            true
        } catch (e: Exception) {
            false
        }
    }

    fun update(guest: GuestModel) {
        try {
            val db = guestDataBase.writableDatabase
            val values = ContentValues()

            val presence = if (guest.presence) 1 else 0
            values.put( DataBaseConstants.GUEST.COLUMNS.NAME, guest.name)
            values.put( DataBaseConstants.GUEST.COLUMNS.PRESENCE, presence)

            val selection = DataBaseConstants.GUEST.COLUMNS.ID + " = ?"
            val args = arrayOf(guest.id.toString())

            db.update(DataBaseConstants.GUEST.TABLE_NAME, values, selection, args)
            true
        } catch (e: Exception) {
            false
        }
    }

    fun delete(id: Int) {
        try {
            val db = guestDataBase.writableDatabase
            val values = ContentValues()

            val selection = DataBaseConstants.GUEST.COLUMNS.ID + " = ?"
            val args = arrayOf(id.toString())

            db.delete(DataBaseConstants.GUEST.TABLE_NAME, selection, args)
            true
        } catch (e: Exception) {
            false
        }
    }

}
package com.example.guestsapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.guestsapp.Model.GuestModel
import com.example.guestsapp.repository.GuestRepository

class GuestFormViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = GuestRepository.getInstance(application)

    fun insert(guest: GuestModel) {
        repository.insert(guest)
    }

}
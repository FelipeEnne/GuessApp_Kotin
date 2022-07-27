package com.example.guestsapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.guestsapp.Model.GuestModel
import com.example.guestsapp.repository.GuestRepository

class GuestFormViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = GuestRepository.getInstance(application)

    private val guestModel = MutableLiveData<GuestModel>()
    val guest: LiveData<GuestModel> = guestModel;

    private val _saveGuest = MutableLiveData<String>()
    val saveGuest: LiveData<String> = _saveGuest;

    fun save(guest: GuestModel) {
        if(guest.id == 0){
            if(repository.insert(guest)) {
                _saveGuest.value = "Insert successful"
            } else {
                _saveGuest.value = "Fail"
            }
        } else {
            if(repository.insert(guest)) {
                _saveGuest.value = "Update successful"
            } else {
                _saveGuest.value = "Fail"
            }
        }
    }

    fun get(id: Int) {
        guestModel.value = repository.get(id)
    }

}
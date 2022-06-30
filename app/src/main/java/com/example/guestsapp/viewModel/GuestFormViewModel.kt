package com.example.guestsapp.viewModel

import androidx.lifecycle.ViewModel
import com.example.guestsapp.repository.GuestRepository

class GuestFormViewModel : ViewModel() {
    private val repository = GuestRepository.getInstance()

}
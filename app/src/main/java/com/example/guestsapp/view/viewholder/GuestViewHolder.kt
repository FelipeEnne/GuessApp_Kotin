package com.example.guestsapp.view.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.guestsapp.Model.GuestModel
import com.example.guestsapp.databinding.RowGuestBinding

class GuestViewHolder(private val bind: RowGuestBinding) : RecyclerView.ViewHolder(bind.root) {
    fun bind(guest: GuestModel) {
        bind.textName.text = guest.name
    }
}
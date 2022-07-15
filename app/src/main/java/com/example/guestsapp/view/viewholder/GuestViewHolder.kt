package com.example.guestsapp.view.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.guestsapp.Model.GuestModel
import com.example.guestsapp.databinding.RowGuestBinding
import com.example.guestsapp.view.listener.OnGuestListener

class GuestViewHolder(private val bind: RowGuestBinding, private val listener: OnGuestListener) : RecyclerView.ViewHolder(bind.root) {
    fun bind(guest: GuestModel) {
        bind.textName.text = guest.name

        bind.textName.setOnClickListener{
            listener.onClick(guest.id)
        }

        bind.textName.setOnLongClickListener{
            listener.onDelete(guest.id)
            true
        }
    }
}
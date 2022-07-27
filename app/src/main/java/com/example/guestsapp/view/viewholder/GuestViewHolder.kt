package com.example.guestsapp.view.viewholder

import android.view.View
import androidx.appcompat.app.AlertDialog
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
            AlertDialog.Builder(itemView.context)
                .setTitle("Remove guest")
                .setMessage("Do you want to remove?")
                .setPositiveButton("Yes"){dialog, which -> listener.onDelete(guest.id)}
                .setNegativeButton("No", null)
                .create()
                .show()

            true
        }
    }
}
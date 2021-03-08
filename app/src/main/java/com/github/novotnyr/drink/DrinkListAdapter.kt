package com.github.novotnyr.drink

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import java.io.Serializable
import java.util.*

// [x] pripravit domenovy drink
// [x] pripravit triedu rozdielov medzi objektmi
// [x]. pripravit ViewHolder
// [x]. pripravit ListAdapter

data class Drink(val id: UUID = UUID.randomUUID()) : Serializable

object DrinkDiff : DiffUtil.ItemCallback<Drink>() {
    override fun areItemsTheSame(oldItem: Drink, newItem: Drink): Boolean {
        // .equals()
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Drink, newItem: Drink): Boolean {
        // .equals()
        return oldItem == newItem
    }
}

class DrinkViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

class DrinkListAdapter : ListAdapter<Drink, DrinkViewHolder>(DrinkDiff) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinkViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.drink_list_item, parent, false)
        return DrinkViewHolder(layout)
    }

    override fun onBindViewHolder(holder: DrinkViewHolder, position: Int) {
        // nebude tu nic
    }
}
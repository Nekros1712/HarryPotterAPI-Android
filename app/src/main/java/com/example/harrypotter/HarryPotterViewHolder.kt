package com.example.harrypotter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HarryPotterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val name : TextView = itemView.findViewById(R.id.name)
    val house : TextView = itemView.findViewById(R.id.house)
    val ancestry : TextView = itemView.findViewById(R.id.ancestry)
    val actor : TextView = itemView.findViewById(R.id.actor)
    val image : ImageView = itemView.findViewById(R.id.image)
}
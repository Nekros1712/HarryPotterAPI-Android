package com.example.harrypotter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class HarryPotterAdapter(
    private val context: Context,
    private val totalData: List<HarryPotterData>?
    ) : RecyclerView.Adapter<HarryPotterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HarryPotterViewHolder {
        val view : View = LayoutInflater.from(context).inflate(R.layout.character_item, parent, false)
        return HarryPotterViewHolder(view)
    }

    override fun onBindViewHolder(holder: HarryPotterViewHolder, position: Int) {
        holder.name.text = totalData!![position].name
        holder.house.text = totalData[position].house
        holder.ancestry.text = totalData[position].ancestry
        holder.actor.text = totalData[position].actor
        Glide.with(context).load(totalData[position].image).into(holder.image)
    }

    override fun getItemCount(): Int {
        return totalData!!.size
    }
}
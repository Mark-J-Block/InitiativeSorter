package com.example.mblock.initiativesorter

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class CharacterAdapter(private val data: ArrayList<Character>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var sortCount = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.edit_character, parent, false) as View
        return CharacterViewHolder(view, data)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as CharacterViewHolder
        if (sortCount > 0) {
            holder.characterWatcher.sort = true
            holder.initiativeWatcher.sort = true
            sortCount--
        }
        holder.characterWatcher.position = position
        holder.initiativeWatcher.position = position
        holder.character.setText(data[position].character)
        holder.initiative.setText(data[position].initiative)
        if (position % 2 == 1){
            holder.character.setBackgroundColor(Color.parseColor("#95C8D8"))
            holder.initiative.setBackgroundColor(Color.parseColor("#95C8D8"))
        } else {
            holder.character.setBackgroundColor(Color.parseColor("#FFFFFF"))
            holder.initiative.setBackgroundColor(Color.parseColor("#FFFFFF"))
        }
        holder.characterWatcher.sort = false
        holder.initiativeWatcher.sort = false
    }

    override fun getItemCount() = data.size
}
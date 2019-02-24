package com.example.mblock.initiativesorter

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class CharacterDeleteAdapter(private val data: ArrayList<Character>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class CharacterDeleteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val character = itemView.findViewById<TextView>(R.id.character_text_delete)!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.delete_character, parent, false) as View
        return CharacterDeleteViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as CharacterDeleteViewHolder
        holder.character.text = data[position].character
        if (position % 2 == 1){
            holder.character.setBackgroundColor(Color.parseColor("#95C8D8"))
        } else {
            holder.character.setBackgroundColor(Color.parseColor("#FFFFFF"))
        }
    }

    override fun getItemCount() = data.size
}
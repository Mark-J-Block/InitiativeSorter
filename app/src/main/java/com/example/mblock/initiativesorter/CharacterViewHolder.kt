package com.example.mblock.initiativesorter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.EditText

class CharacterViewHolder(itemView: View, data: ArrayList<Character>) : RecyclerView.ViewHolder(itemView) {
    val character = itemView.findViewById<EditText>(R.id.character_text)!!
    val initiative = itemView.findViewById<EditText>(R.id.initiative_text)!!
    val characterWatcher = InitiativeWatcher(data, "character")
    val initiativeWatcher = InitiativeWatcher(data, "initiative")

    init {
        character.addTextChangedListener(characterWatcher)
        initiative.addTextChangedListener(initiativeWatcher)
    }
}
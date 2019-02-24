package com.example.mblock.initiativesorter

import android.text.Editable
import android.text.TextWatcher

class InitiativeWatcher(val data: ArrayList<Character>, val type: String) : TextWatcher {
    var position = -1
    var sort = false

    override fun afterTextChanged(s: Editable?) {
        if (!sort) {
            if (type == "character")
                data[position].character = s.toString()
            else if (type == "initiative")
                data[position].initiative = s.toString()
        }
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit
    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) = Unit
}
package com.example.mblock.initiativesorter

import android.content.Intent
import android.content.pm.ActivityInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import kotlin.collections.*

class SortActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewManager: LinearLayoutManager
    private lateinit var viewAdapter: CharacterAdapter
    private var characters = ArrayList<Character>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setContentView(R.layout.activity_sort)
        val otherActivityCharacters: ArrayList<Character>
        if (intent != null && intent.extras != null && intent.extras.get("characters") != null) {
            otherActivityCharacters = intent.extras.get("characters") as ArrayList<Character>
            if (otherActivityCharacters != null) {
                characters = otherActivityCharacters
                if (characters.size < 2) {
                    addEmptyCharacter(characters, 2 - characters.size)
                }
            }
        } else {
            addEmptyCharacter(characters, 2)
        }

        viewAdapter = CharacterAdapter(characters)
        viewManager = LinearLayoutManager(this)
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = viewManager
        recyclerView.adapter = viewAdapter
    }

    private fun addEmptyCharacter(characters: ArrayList<Character>, numberToAdd: Int) {
        for (i in 1..numberToAdd)
            characters.add(Character("", ""))
    }

    fun add(view: View) {
        addEmptyCharacter(characters, 1)
        viewAdapter.notifyItemInserted(characters.size - 1)
    }

    fun sort(view: View) {
        characters.sort()
        viewAdapter.sortCount = characters.size
        viewAdapter.notifyItemRangeChanged(0, characters.size)
    }

    fun reset(view: View) {
        characters.clear()
        addEmptyCharacter(characters, 2)
        resetAdapter()
    }

    private fun resetAdapter() {
        viewAdapter = CharacterAdapter(characters)
        recyclerView.adapter = viewAdapter
    }

    fun deleteCharacters(view: View) {
        val intent = Intent(this, DeleteActivity::class.java).apply {
            putExtra("characters", characters)
        }
        startActivity(intent)
    }
}

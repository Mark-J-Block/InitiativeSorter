package com.example.mblock.initiativesorter

import android.content.Intent
import android.view.View
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

class DeleteActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewManager: LinearLayoutManager
    private lateinit var viewAdapter: CharacterDeleteAdapter
    private lateinit var characters: ArrayList<Character>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setContentView(R.layout.activity_delete)
        characters = intent.extras.get("characters") as ArrayList<Character>
        viewAdapter = CharacterDeleteAdapter(characters)
        viewManager = LinearLayoutManager(this)
        recyclerView = findViewById(R.id.recycler_view_delete)
        recyclerView.layoutManager = viewManager
        recyclerView.adapter = viewAdapter

        val onItemTouchListener = RecyclerTouchListener(applicationContext, recyclerView, object : RecyclerTouchListener.ClickListener {
            override fun onClick(view: View, position: Int, x: Float, y: Float) {
                characters.removeAt(position)
                viewAdapter.notifyDataSetChanged()
            }

            override fun onLongClick(view: View, position: Int, x: Float, y: Float) {
            }
        })
        recyclerView.addOnItemTouchListener(onItemTouchListener)
    }

    fun exit(view: View){
        val intent = Intent(this, SortActivity::class.java).apply {
            putExtra("characters", characters)
        }
        startActivity(intent)
    }
}
package com.example.demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView

class NoteListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)

        val fab: View = findViewById(R.id.fab1)
        fab.setOnClickListener { view ->
            val activityIntent = Intent(this,MainActivity::class.java)
                startActivity(activityIntent)
        }
        val list = findViewById<ListView>(R.id.listNotes)
        list.adapter = ArrayAdapter(this,
        android.R.layout.simple_list_item_1,
        DataManager.notes)

        list.setOnItemClickListener{parent,view,position,id ->
            val activityIntent = Intent(this,MainActivity::class.java)
            activityIntent.putExtra(NOTE_POSITION,position)
            startActivity(activityIntent)
        }
    }

    override fun onResume() {
        super.onResume()
        val list = findViewById<ListView>(R.id.listNotes)
        (list.adapter as ArrayAdapter<NoteInfo>).notifyDataSetChanged()
    }
}
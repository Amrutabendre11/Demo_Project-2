package com.example.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView

class NoteActicity : AppCompatActivity() {
    private  val tag =  this::class.simpleName
    private var notePosition = POSITION_NOT_SET
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapterCourese = ArrayAdapter<CourseInfo>(this,
        android.R.layout.simple_spinner_item,
        DataManager.courses.values.toList())
        adapterCourese.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        val spinnerCourese = findViewById<Spinner>(R.id.mySpinner)
        spinnerCourese.adapter = adapterCourese
        notePosition = savedInstanceState?.getInt(NOTE_POSITION, POSITION_NOT_SET) ?:
        intent.getIntExtra(NOTE_POSITION, POSITION_NOT_SET)

        if(notePosition != POSITION_NOT_SET)

            DisplayNote()
        else
        {
            createNewNote()
        }
    }

    private fun createNewNote() {

    }

    private fun DisplayNote() {
        val note = DataManager.notes[notePosition]
        val textNoteTitle1 = findViewById<TextView>(R.id.textNoteTitle)
        textNoteTitle1.setText(note.title)
        val textNoteText1 = findViewById<TextView>(R.id.textNoteText)
        textNoteText1.setText(note.text)

        val coursePositons = DataManager.courses.values.indexOf(note.course)
        val spinnerCourese = findViewById<Spinner>(R.id.mySpinner)
        spinnerCourese.setSelection(coursePositons)
    }
}
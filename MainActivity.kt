package com.example.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import com.example.demo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var notePosition = POSITION_NOT_SET
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val adapterCoures = ArrayAdapter<CourseInfo>(this,
            android.R.layout.simple_spinner_item,
            DataManager.courses.values.toList())
        adapterCoures.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        val spinnerCourese = findViewById<Spinner>(R.id.mySpinner)
        spinnerCourese.adapter = adapterCoures

        notePosition = savedInstanceState?.getInt(NOTE_POSITION, POSITION_NOT_SET)?:
            intent.getIntExtra(NOTE_POSITION, POSITION_NOT_SET)

        if(notePosition != POSITION_NOT_SET)
            DisplayNote()
        else{
            DataManager.notes.add(NoteInfo())
            notePosition = DataManager.notes.lastIndex
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState?.putInt(NOTE_POSITION,notePosition)
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

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.menu,menu)
//        return true
//    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.option, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.settings -> true
            R.id.next ->{

                moveNext()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun moveNext() {
        ++notePosition
        DisplayNote()
        invalidateOptionsMenu()
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        if(notePosition >= DataManager.notes.lastIndex) {
        val menuItem = menu?.findItem(R.id.next)
            if(menuItem != null){
                menuItem.icon =getDrawable(R.drawable.ic_baseline_block_24)
                menuItem.isEnabled = false
            }
        }
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onPause() {
        super.onPause()
        saveNote()
    }

    private fun saveNote() {
        val note = DataManager.notes[notePosition]

        val textNoteTitle1 = findViewById<TextView>(R.id.textNoteTitle)
        note.title = textNoteTitle1.text.toString()
        val textNoteText1 = findViewById<TextView>(R.id.textNoteText)
        note.text = textNoteText1.text.toString()
        val spinnerCourese = findViewById<Spinner>(R.id.mySpinner)
        note.course = spinnerCourese.selectedItem as CourseInfo
    }
}


package com.example.demo

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteRecyclerAdapter (private val context: Context, private val notes: ArrayList<NoteInfo>):
    RecyclerView.Adapter<NoteRecyclerAdapter.MyViewHolder>() {
    private val inflater : LayoutInflater = LayoutInflater.from(context)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = inflater.inflate(R.layout.card_view_design,parent,false)
        return  MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val note = notes[position]
        holder.textCourses?.text = note.course?.title
        holder.textTitle?.text=note.title
        holder.notePosition = position
    }

    override fun getItemCount() = notes.size

    inner class MyViewHolder(itemView : View): RecyclerView.ViewHolder(itemView ) {
        val textCourses =itemView?.findViewById<TextView>(R.id.textCourses)
        val textTitle =itemView?.findViewById<TextView>(R.id.textTite)
        var notePosition = 0

        init {
            itemView?.setOnClickListener {
                val intent = Intent(context, NoteActicity::class.java)
                intent.putExtra(NOTE_POSITION, notePosition)
                context.startActivity(intent)
            }
        }
    }
}

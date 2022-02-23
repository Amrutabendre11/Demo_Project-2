package com.example.demo

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.DataManager.courses

class CoursesRecyclerAdapter(private val context: Context,private val courses: List<CourseInfo>):RecyclerView.Adapter<CoursesRecyclerAdapter.MyViewHolder>() {
    private val inflater :LayoutInflater = LayoutInflater.from(context)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = inflater.inflate(R.layout.card_course,parent,false)
        return  MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val course = courses[position]
        holder.textCourses11 ?.text = course?.title
        holder.notePosition = position
    }

    override fun getItemCount() = courses.size

   inner class MyViewHolder(itemView : View): RecyclerView.ViewHolder(itemView ) {
        val  textCourses11 = itemView?.findViewById<TextView>(R.id.textCourses1)
        var  notePosition = 0;

        init {
            itemView?.setOnClickListener {
                val intent = Intent(context, NoteActicity::class.java)
                intent.putExtra(NOTE_POSITION, notePosition)
                context.startActivity(intent)
            }
        }
    }
}

package com.example.demo

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.databinding.ActivityItemsBinding

class ItemsActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityItemsBinding
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var actionBarToggle: ActionBarDrawerToggle
    private lateinit var nav_View1: NavigationView
    private val noteLayoutManager by lazy {
        LinearLayoutManager(this)
    }
    private val noteRecyclerAdapter by lazy {
        NoteRecyclerAdapter(this, DataManager.notes)
    }
    private val coursesLayoutManager by lazy {
        GridLayoutManager(this, resources.getInteger(R.integer.courses_grid_span))
    }
    private val coursesRecyclerAdapter by lazy {
        CoursesRecyclerAdapter(this, DataManager.courses.values.toList())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityItemsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarItems.toolbar)

        binding.appBarItems.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val navView: NavigationView = binding.navView

//        appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
//            ), drawerLayout
//        )
        drawerLayout = findViewById(R.id.drawer_layout)
        actionBarToggle = ActionBarDrawerToggle(
            this, drawerLayout, 0, 0
        )
        drawerLayout.addDrawerListener(actionBarToggle)


        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        actionBarToggle.syncState()

      //  navView.setNavigationItemSelectedListener { menuItem ->
//             when (menuItem.itemId) {
//                 R.id.Courses -> {
//                     Toast.makeText(this, "Courses", Toast.LENGTH_SHORT).show()
//                     true
//                 }
//                 R.id.Notes -> {
//                     Toast.makeText(this, "Notes", Toast.LENGTH_SHORT).show()
//                     true
//                 }
//                 R.id.nav_share -> {
//                     Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show()
//                     true
//                 }
//                 R.id.nav_Send ->{
//                     Toast.makeText(this, "nav_send", Toast.LENGTH_SHORT).show()
//                     true
//                 }
//                 R.id.nav_how_many ->{
//                     Toast.makeText(this, "howmajn", Toast.LENGTH_SHORT).show()
//                     true

//                 }
//                 else -> {
//                     false
//                 }
//             }
        }
        //DisplayNotes()
        DisplayCourses()

    }

@Override
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
       when (item.itemId) {
           R.id.Courses -> {
               DisplayCourses()
           }
           R.id.Notes -> {
               DisplayNotes()
           }
           R.id.nav_share -> {
               handleSelection(R.string.nav_share_message)
           }
           R.id.nav_Send ->{
               handleSelection(R.string.send)
           }
           R.id.nav_how_many ->{
               val message = getString(R.string.how_many,
               DataManager.notes.size,DataManager.courses.size)
               val listItems = findViewById<RecyclerView>(R.id.listItems)
               Snackbar.make(listItems,message,Snackbar.LENGTH_LONG).show()

           }
       }
       drawerLayout.closeDrawer(GravityCompat.START)
       return true
   }

    private fun handleSelection(stringId: Int) {
        val listItems = findViewById<RecyclerView>(R.id.listItems)
        Snackbar.make(listItems, stringId,Snackbar.LENGTH_LONG).show()
    }

    private fun DisplayCourses() {

        val listItem1 = findViewById<RecyclerView>(R.id.listItems)
        listItem1.layoutManager = coursesLayoutManager
        listItem1.adapter = coursesRecyclerAdapter


        val nav_View = findViewById<NavigationView>(R.id.nav_view)
        nav_View.menu.findItem(R.id.Courses).isChecked = true
    }

    private fun DisplayNotes() {
        val listItem1 = findViewById<RecyclerView>(R.id.listItems)
        listItem1.layoutManager = noteLayoutManager
        listItem1.adapter = noteRecyclerAdapter


        val nav_View = findViewById<NavigationView>(R.id.nav_view)
        nav_View.menu.findItem(R.id.Notes).isChecked = true
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }


    @SuppressLint("WrongConstant")


    override fun onBackPressed() {
        if (this.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            this.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }


}

package com.example.wahyupermadi.footballteam.view.DetailView

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.wahyupermadi.footballteam.R
import com.example.wahyupermadi.footballteam.R.id.add_to_favorite
import com.example.wahyupermadi.footballteam.R.menu.detail_menu
import org.jetbrains.anko.toast

class DetailActivity : AppCompatActivity() {
    private var menuItem: Menu? = null
    private var isFavorite: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        intent = intent
        val id : String = intent.getStringExtra("id")
        toast(id)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(detail_menu, menu)
        menuItem = menu
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item!!.itemId){
            android.R.id.home -> {
                finish()
                true
            }

            add_to_favorite -> {

                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}

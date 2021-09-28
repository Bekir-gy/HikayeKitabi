package com.bekirgy.storybookapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import java.time.temporal.TemporalAdjusters.next
import java.util.*
import kotlin.random.Random

class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {
    var storyTitles = arrayOf<String>()
    var storyContents = arrayOf<String>()
    var storyImages= arrayOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        val toggle=ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close)
        toggle.isDrawerIndicatorEnabled=true
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()


        navigatonView.setNavigationItemSelectedListener(this)
        storyTitles= resources.getStringArray(R.array.storyTitle)
        storyContents=resources.getStringArray(R.array.storyContent)
        storyImages=resources.getStringArray(R.array.storyImages)

        val adapter= ItemAdapter(storyTitles,storyContents,storyImages)

        storyList.layoutManager=LinearLayoutManager(this)
        storyList.adapter=adapter


    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
       drawerLayout.closeDrawer(GravityCompat.START)
        if(item.itemId==R.id.random){
            val randPosition= Random.nextInt(0,storyTitles.size)
            val intent= Intent(applicationContext,Details::class.java)
            intent.putExtra("storyTitle",storyTitles[randPosition])
            intent.putExtra("storyContent",storyContents[randPosition])
            intent.putExtra("storyImage",storyImages[randPosition])
            startActivity(intent)
        }

        else if(item.itemId==R.id.rate){
            val  intent=Intent(applicationContext,Rateus::class.java)
            startActivity(intent)
        }



        return true
    }
}
package com.bekirgy.storybookapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.widget.Button
import android.widget.RatingBar
import android.widget.Toast
import com.bekirgy.storybookapp.databinding.ActivityRateusBinding
import kotlinx.android.synthetic.main.activity_rateus.*

class Rateus : AppCompatActivity() {

lateinit var binding: ActivityRateusBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityRateusBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        //action bar kısmında geri butonu
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.ratingBar.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
           binding.textView2.text=rating.toString()

            val ratings: Int =0 //BİR ŞEYE YARAMIYOR
            var myreport:String = ""

            when(rating.toInt()){
                1-> myreport="kötü"
                2-> myreport="kötünün iyisi"
                3-> myreport="orta"
                4-> myreport="iyi"
                5-> myreport="çok iyi"
            }
            Toast.makeText(this,myreport,Toast.LENGTH_SHORT).show()
        }

        binding.button.setOnClickListener {
            //binding.textView3.text=binding.ratingBar.rating.toString()
            Toast.makeText(this,"Verdiğiniz Oy:  "+binding.ratingBar.rating.toString(),Toast.LENGTH_LONG).show()
        }



    }


    override fun onOptionsItemSelected(item: MenuItem):Boolean{
        if(item.itemId==android.R.id.home){
            onBackPressed()
        }


        return  super.onOptionsItemSelected(item)
    }
}
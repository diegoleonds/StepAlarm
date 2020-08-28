package com.example.stepalarm.view.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.stepalarm.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setClicks()
    }

    private fun setClicks(){
        fabAddAlarm.setOnClickListener{
            val intent = Intent(this, AddAlarmActivity::class.java)
            startActivity(intent)
        }
    }
}
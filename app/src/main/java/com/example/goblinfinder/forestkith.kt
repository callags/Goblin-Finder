package com.example.goblinfinder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class forestkith : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forestkith)

        //Back button
        val Backbtn = findViewById<Button>(R.id.backBtn)
        //Back button handler
        Backbtn.setOnClickListener {
            //Back being pressed
            startActivity(Intent(this@forestkith, MainActivity::class.java))
        }
    }
}

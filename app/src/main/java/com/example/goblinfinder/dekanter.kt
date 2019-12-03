package com.example.goblinfinder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class dekanter : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dekanter)

        //Back button
        val Backbtn = findViewById<Button>(R.id.backBtn)
        //Back button handler
        Backbtn.setOnClickListener {
            //Back being pressed
            startActivity(Intent(this@dekanter, MainActivity::class.java))
        }
    }
}

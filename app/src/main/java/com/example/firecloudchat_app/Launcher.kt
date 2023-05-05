package com.example.firecloudchat_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Launcher : AppCompatActivity() {

    private lateinit var txt_welcome:TextView
    private lateinit var txt_about:TextView
    private lateinit var txt_thanks:TextView
    private lateinit var btn_proceed:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)

        txt_welcome = findViewById(R.id.mtxtWelcom)
        txt_about = findViewById(R.id.mtxtAbout)
        txt_thanks = findViewById(R.id.mtxtThanks)
        btn_proceed = findViewById(R.id.mbtnProceed)


        btn_proceed.setOnClickListener {
            var gotologin = Intent(this,LoginActivity::class.java)
            startActivity(gotologin)

        }

    }
}
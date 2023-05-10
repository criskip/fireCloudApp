package com.example.firecloudchat_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class Splashscreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed(
            {
                val intent = Intent(this,Launcher::class.java)
                startActivity(intent)
                finish()
            }, 3000
        )
    }
}
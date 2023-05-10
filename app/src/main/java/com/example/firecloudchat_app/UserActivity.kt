package com.example.firecloudchat_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firecloudchat_app.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {

    private lateinit var binding : ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("name")
        val phone = intent.getStringExtra("phone")
        val town = intent.getStringExtra("town")
        val imageid = intent.getIntExtra("imageid",R.drawable.bag)

        binding.nameProfile.text = name
        binding.phoneProfile.text = phone
        binding.townProfile.text = town
        binding.imageProfile.setImageResource(imageid)


    }
}
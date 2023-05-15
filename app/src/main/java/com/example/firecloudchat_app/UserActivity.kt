package com.example.firecloudchat_app

import android.app.Notification.Action
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.firecloudchat_app.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {

    private lateinit var binding : ActivityUserBinding
    private lateinit var btn_call : Button
    private lateinit var btn_message : Button
    private lateinit var phone_num : TextView

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

        btn_call = findViewById(R.id.mbtnCall)
        btn_message = findViewById(R.id.mbtnMessage)
        phone_num = findViewById(R.id.phoneProfile)

        btn_call.setOnClickListener {
            var num = phone_num.text.toString().trim()
            var intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:$num")
            startActivity(intent)
        }

        btn_message.setOnClickListener {
            var num2 = phone_num.text.toString().trim()
            var uri = Uri.parse("smsto:$num2")
            var intent = Intent(Intent.ACTION_SENDTO, uri)
            startActivity(intent)
        }



    }
}
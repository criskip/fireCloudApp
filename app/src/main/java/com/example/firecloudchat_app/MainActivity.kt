package com.example.firecloudchat_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var edt_user_input:EditText
    private lateinit var btnSave_data:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edt_user_input = findViewById(R.id.edt_data)
        btnSave_data = findViewById(R.id.btn_save)

        //initialize firebase
        var database = FirebaseDatabase.getInstance()
        var databaseRef = database.reference




        btnSave_data.setOnClickListener {

            var user_data = edt_user_input.text.toString().trim()
            //Toast.makeText(this, user_data, Toast.LENGTH_SHORT).show()
            databaseRef.setValue(user_data)

        }

    }
}
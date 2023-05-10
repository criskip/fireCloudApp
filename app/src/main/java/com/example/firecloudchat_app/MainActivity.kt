package com.example.firecloudchat_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

     private lateinit var edtMake:EditText
     private lateinit var edtModel:EditText
     private lateinit var edtPrice:EditText
     private lateinit var btnPhoto:Button
     private lateinit var btnData:Button
     private lateinit var btnCars:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtMake = findViewById(R.id.mEdt_make)
        edtModel = findViewById(R.id.mEdt_model)
        edtPrice = findViewById(R.id.mEdt_price)
        btnPhoto = findViewById(R.id.mbtnPhoto)
        btnData = findViewById(R.id.mbtnCarData)
        btnCars = findViewById(R.id.mbntCars)

        //initialize firebase
        var database = FirebaseDatabase.getInstance()
        var databaseRef = database.getReference("cars")

        btnPhoto.setOnClickListener {

        }

        btnData.setOnClickListener {
            var make = edtMake.text.toString().trim()
            var model = edtModel.text.toString().trim()
            var price = edtPrice.text.toString().trim()

            if (make.isEmpty() || model.isEmpty() || price.isEmpty()) {
                Toast.makeText(this, "You cannot submit an empty field", Toast.LENGTH_SHORT).show()
            } else {
                //saving info to firebase db
                var usercar = Car(make, model, price)

                var ref = FirebaseDatabase.getInstance().getReference().child("cars")

                ref.setValue(usercar).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Toast.makeText(this, "Car Data Uploaded Successfully", Toast.LENGTH_SHORT)
                            .show()

                    } else {
                        Toast.makeText(this, "Failed to save Car Info", Toast.LENGTH_SHORT).show()
                    }
                }
            }

        }

    btnCars.setOnClickListener {

    }



    }

}
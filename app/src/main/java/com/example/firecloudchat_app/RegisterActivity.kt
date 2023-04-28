package com.example.firecloudchat_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity() {

    private lateinit var edt_name:EditText
    private lateinit var edt_email:EditText
    private lateinit var edt_password:EditText
    private lateinit var btn_createAccount:Button

    //initialize firebase
    lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        edt_name = findViewById(R.id.mEdt_name)
        edt_email = findViewById(R.id.email_edt)
        edt_password = findViewById(R.id.password_edt)
        btn_createAccount = findViewById(R.id.mbtn_createAcc)

        //initialize firebase again
        auth = FirebaseAuth.getInstance()

        btn_createAccount.setOnClickListener {

          var name = edt_name.text.toString().trim()
          var email = edt_email.text.toString().trim()
          var password = edt_password.text.toString().trim()

          //validate your input

          if (name.isEmpty() || email.isEmpty() || password.isEmpty()){
              Toast.makeText(this, "One of the fields is empty", Toast.LENGTH_SHORT).show()
          }else {
              //create a user in firebase

              auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(){
                  if(it.isSuccessful){
                      Toast.makeText(this, "User created successfully", Toast.LENGTH_SHORT).show()

                      var gotologin = Intent(this,LoginActivity::class.java)
                      startActivity(gotologin)
                  } else{
                      Log.d("TAG","Error---->", it.exception)

                      Toast.makeText(this, "Failed to create account", Toast.LENGTH_SHORT).show()
                  }




              }

          }

        }

    }
}
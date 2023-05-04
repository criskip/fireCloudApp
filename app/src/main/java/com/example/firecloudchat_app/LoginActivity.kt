package com.example.firecloudchat_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var edtEmail:EditText
    private lateinit var edtPassword:EditText
    private lateinit var btnLogin:Button
    private lateinit var btnRegister:Button
    private lateinit var auth: FirebaseAuth
    private lateinit var bar:ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)




        edtEmail = findViewById(R.id.mEdt_Email)
        edtPassword = findViewById(R.id.mEdt_Password)
        btnLogin = findViewById(R.id.mbtn_login)
        btnRegister = findViewById(R.id.mbtn_register)
        bar = findViewById(R.id.progressBar)

        bar.visibility = View.INVISIBLE


        auth = FirebaseAuth.getInstance()

        btnLogin.setOnClickListener {

            var user_email = edtEmail.text.toString().trim()
            var user_pass = edtPassword.text.toString().trim()
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()

        }

        btnLogin.setOnClickListener {

         var mail = edtEmail.text.toString().trim()
         var pass = edtPassword.text.toString().trim()
            bar.visibility = View.VISIBLE

         //validate input

         if (mail.isEmpty() || pass.isEmpty()){
             Toast.makeText(this, "One of the inputs is empty", Toast.LENGTH_SHORT).show()
         }else{
             auth.signInWithEmailAndPassword(mail, pass).addOnCompleteListener(this){
                 if (it.isSuccessful){
                     Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
                     var gotomain = Intent(this, MainActivity::class.java)
                     startActivity(gotomain)
                     finish()
                 }else{
                     Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
                 }
             }
         }

        }

        btnRegister.setOnClickListener {
            var gotoregister = Intent(this,RegisterActivity::class.java)
            startActivity(gotoregister)
        }
    }
}
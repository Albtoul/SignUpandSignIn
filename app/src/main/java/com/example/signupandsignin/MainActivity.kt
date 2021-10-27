package com.example.signupandsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {//class for intent between activity signin & signup

    lateinit var signin:Button
    lateinit var signup:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        signin=findViewById(R.id.button)
        signup=findViewById(R.id.button2)

        signin.setOnClickListener {
            var intent = Intent(applicationContext, signIn::class.java)
            startActivity(intent)

        }
        signup.setOnClickListener {
            var intent = Intent(applicationContext, signUp::class.java)
            startActivity(intent)
        }
    }
}
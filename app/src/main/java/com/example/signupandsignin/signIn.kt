package com.example.signupandsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class signIn : AppCompatActivity() { //class for signin
        lateinit var mobile:EditText
        lateinit var password:EditText
        lateinit var login:Button
        var s1=""//use it for  mobile edit text
        var s2=""//use it for password edit text
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        login=findViewById(R.id.button3)
        mobile=findViewById(R.id.editTextTextPersonName)
        password=findViewById(R.id.editTextTextPersonName2)

        login.setOnClickListener {
            s1=mobile.text.toString()
            s2=password.text.toString()
            var dbhr = DBHlpr(applicationContext)
            var x=dbhr.checkpassword(s1)

            if(x.equals(s2)){//send value to check password function in DBHlpr class

                Toast.makeText(applicationContext, "signIn success", Toast.LENGTH_SHORT).show()
                 intent = Intent(applicationContext, profilePage::class.java)
                intent.putExtra("note",s1)
                startActivity(intent)

            }else{
                Toast.makeText(applicationContext, "please enter a valid number", Toast.LENGTH_SHORT).show()//to show error message
            }
        }



    }
}
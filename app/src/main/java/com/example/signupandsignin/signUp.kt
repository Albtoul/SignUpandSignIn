package com.example.signupandsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class signUp : AppCompatActivity() { //class for signup
    lateinit var name:EditText
    lateinit var mobile:EditText
    lateinit var location:EditText
    lateinit var password:EditText
    lateinit var signUp:Button
    var s1=""//use for name edittext
    var s2=""//use for mobile edittext
    var s3=""//use for location edittext
    var s4=""//use for password edittext
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        name=findViewById(R.id.editTextTextPersonName3)
        mobile=findViewById(R.id.editTextTextPersonName4)
        location=findViewById(R.id.editTextTextPersonName5)
        password=findViewById(R.id.editTextTextPersonName6)
        signUp=findViewById(R.id.button4)
        signUp.setOnClickListener {
            s1=name.text.toString()         //connect the edtext with variable
            s2=mobile.text.toString()
            s3=location.text.toString()
            s4=password.text.toString()
            if((s1!=null)&&(s2!=null)&&(s3!=null)&&(s4!=null)) {  //make sure the value not null
                var dbhr = DBHlpr(applicationContext)
                var stat = dbhr.save(s1, s2, s3, s4)      // send value to DBHlpr class to saving data in db
                Toast.makeText(applicationContext, "registerd" + stat, Toast.LENGTH_SHORT).show()

                    intent = Intent(applicationContext, profilePage::class.java)
                    intent.putExtra("notes",s2) // send value to profilepage
                    startActivity(intent)





            }else{
                Toast.makeText(applicationContext, "invalid!! full all argument", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
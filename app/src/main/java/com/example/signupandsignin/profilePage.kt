package com.example.signupandsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class profilePage : AppCompatActivity() {//use profilepage class to show the data after signin &signup by specific result
    lateinit var signout:Button
    lateinit var recyclerview:RecyclerView
     var arr= arrayListOf<List<String>>()
    val dbhr =DBHlpr(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_row)

       recyclerview=findViewById(R.id.rv)
        signout=findViewById(R.id.button5)
        updaterv()
        updaterv2()
        signout.setOnClickListener {
             intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent) }
    }
    fun updaterv(){
        var x=intent.getStringExtra("note").toString()
        arr.addAll(dbhr.retrive(x))
        recyclerview.adapter=RV(arr)
        recyclerview.layoutManager=LinearLayoutManager(this)


    }
    fun updaterv2(){

        var x=intent.getStringExtra("notes").toString()
        arr.addAll(dbhr.retrive(x))
        recyclerview.adapter=RV(arr)
        recyclerview.layoutManager=LinearLayoutManager(this)

    }

}
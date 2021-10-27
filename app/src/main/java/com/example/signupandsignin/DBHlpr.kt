package com.example.signupandsignin

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
//data base class
class DBHlpr(context:Context):SQLiteOpenHelper(context,"sign.db",null,1) {
    lateinit var sqliteDatabase :SQLiteDatabase

    override fun onCreate(db: SQLiteDatabase?) {
        if(db!=null){
            db.execSQL("create table signtable( Name text ,mobile text ,location text , password text)")

        }
    }//function to creat table and culomn

    override fun onUpgrade(db: SQLiteDatabase?, older: Int, newr: Int) {}
// function to save data in database
    fun save(s1:String,s2:String,s3:String,s4:String){

         sqliteDatabase =writableDatabase
        val cv=ContentValues()
        cv.put("Name",s1)
        cv.put("mobile",s2)
        cv.put("location",s3)
        cv.put("password",s4)
        sqliteDatabase.insert("signtable",null,cv)

    }
//function to get data from data base
    @SuppressLint("Range")
    fun retrive(x:String): ArrayList<List<String>> {
         sqliteDatabase =readableDatabase
        val c:Cursor=sqliteDatabase.query("signtable",null,"mobile=?", arrayOf(x),null,null,null)
        val list= arrayListOf<List<String>>()
// looping in list to get value
        if(c.moveToFirst()){
            do {

                list.add(listOf(
               c.getString(c.getColumnIndex("Name")),
               c.getString(c.getColumnIndex("mobile")),
               c.getString(c.getColumnIndex("location")),
               c.getString(c.getColumnIndex("password"))
           ))
            }while (c.moveToNext())

        }
     return list
    }

//use  check password function to check data for sign in
    @SuppressLint("Range")
    fun checkpassword(mobile: String): String {

         sqliteDatabase =writableDatabase
        var c: Cursor = sqliteDatabase.query(
            "signtable", null, "mobile=?", arrayOf(mobile), null, null, null
        )
        if (c.count < 1) {
            return "name not exists"
        }
        c.moveToFirst()
        var loc = c.getString(c.getColumnIndex("password"))
        return loc
    }


}
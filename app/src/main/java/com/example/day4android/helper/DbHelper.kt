package com.example.day4android.helper

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.widget.Toast

class DbHelper(context:Context) : SQLiteOpenHelper(context, "myDb",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val qurey = "CREATE TABLE $TABLE_NAME (" +
                "$USER_ID_COL INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$USER_EMAIL_COL TEXT," +
                "$USER_PASSWORD_COL TEXT)"

        db?.execSQL(qurey)
    }

    fun connect(){
        Log.d("db","connected")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun createUser(email:String,password:String){
        var db = this.writableDatabase
        var cv = ContentValues()
        cv.put(USER_EMAIL_COL,email)
        cv.put(USER_PASSWORD_COL,password)
        db.insert(TABLE_NAME,null, cv)
        db.close()
    }


    companion object {
        val TABLE_NAME = "user"
        val USER_ID_COL = "id"
        val USER_EMAIL_COL ="email"
        val USER_PASSWORD_COL ="password"
    }
}
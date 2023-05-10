package com.example.day4android.helper

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DbHelper(context:Context) : SQLiteOpenHelper(context, "myDb",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val qurey = "CREATE TABLE $TABLE_NAME ("+
                "$USER_ID_COL INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "$USER_EMAIL_COL TEXT,"+
                "$USER_PASSWORD_COL TEXT)"

        db?.execSQL(qurey)
    }

    fun connect(){
        Log.d("db","connected")
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun createUser(email:String,password:String):Boolean{
        var db = this.writableDatabase
        var cv = ContentValues()
        cv.put(USER_EMAIL_COL,email)
        cv.put(USER_PASSWORD_COL,password)
       var result= db.insert(TABLE_NAME,null, cv)
        db.close()
        return  !result.equals(-1)
    }

    fun signIn(email:String,password:String):Boolean{
        var db = this.readableDatabase
        var cols = arrayOf(USER_ID_COL, USER_EMAIL_COL, USER_PASSWORD_COL)
        var selections = "$USER_EMAIL_COL=? AND $USER_PASSWORD_COL=?"
        var selcArgs = arrayOf(email,password)

        var cursor :Cursor = db.query(TABLE_NAME, cols,selections, selcArgs,null,null,null)

        var count = cursor.count

        return count != 0

    }

    fun deleteUser(id:String){
        // todo:  create delete function which delete a user from the database
    }



    companion object {
        val TABLE_NAME = "user"
        val USER_ID_COL = "id"
        val USER_EMAIL_COL ="email"
        val USER_PASSWORD_COL ="password"
    }
}
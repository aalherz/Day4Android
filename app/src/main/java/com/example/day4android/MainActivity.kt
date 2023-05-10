package com.example.day4android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.day4android.databinding.ActivityMainBinding
import com.example.day4android.helper.DbHelper

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var dbHelper = DbHelper(this)
        
//        var button = findViewById<>()
        binding.buttonLogin.setOnClickListener {
            
            if(binding.emailET.text.isEmpty()&& binding.editTextPassword.text.isEmpty()){
                Toast.makeText(this, "لابد من ادخال القيم", Toast.LENGTH_SHORT).show()
            }else{
                if(dbHelper.signIn(binding.emailET.text.toString().trim(),binding.editTextPassword.text.toString().trim())){
                    Toast.makeText(this, "user logged", Toast.LENGTH_SHORT).show()
                    var i = Intent(this,Home::class.java)
                    startActivity(i)
                }else {
                    Toast.makeText(this, "email or password is wrong", Toast.LENGTH_SHORT).show()
                }
            }
            
            Toast.makeText(this, "test", Toast.LENGTH_SHORT).show()
        }
        binding.buttonSign.setOnClickListener {
            
            // Todo: create email validation for this button
        if(binding.emailET.text.isEmpty()&& binding.editTextPassword.text.isEmpty()){
            Toast.makeText(this, "لابد من ادخال القيم", Toast.LENGTH_SHORT).show()
        } else{
            if(dbHelper.createUser(binding.emailET.text.toString().trim(),binding.editTextPassword.text.toString().trim())){
                Toast.makeText(this, "User has been created", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Somthing went wrong", Toast.LENGTH_SHORT).show()
            }
                
        }
            
        }

    }
}
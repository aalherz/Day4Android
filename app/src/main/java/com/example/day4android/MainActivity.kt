package com.example.day4android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.day4android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        
//        var button = findViewById<>()
        binding.buttonLogin.setOnClickListener {
            Toast.makeText(this, "test", Toast.LENGTH_SHORT).show()
        }

    }
}
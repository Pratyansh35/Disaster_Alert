package com.example.help_disaster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.help_disaster.databinding.ActivityMenuForumsBinding

class MenuForums : AppCompatActivity() {
    private lateinit var binding: ActivityMenuForumsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuForumsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnForm.setOnClickListener {
            val intent = Intent(this, AfterForm::class.java)
            startActivity(intent)
        }
    }
}
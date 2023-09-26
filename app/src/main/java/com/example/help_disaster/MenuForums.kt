package com.example.help_disaster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import com.example.help_disaster.databinding.ActivityMenuForumsBinding

class MenuForums : AppCompatActivity() {
    private lateinit var binding: ActivityMenuForumsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuForumsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnForm.setOnClickListener {
            val intent = Intent(this, AfterForm::class.java)
            startActivity(intent)  }
            val runningText = binding.runningText

            // Define the animation

            // Define the animation
            val animation: Animation = TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 1.0f,
                Animation.RELATIVE_TO_PARENT, -1.0f,
                Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, 0f
            )
            animation.duration = 6400 // Duration in milliseconds

            animation.repeatMode = Animation.RESTART
            animation.repeatCount = Animation.INFINITE

            // Start the animation

            // Start the animation
            runningText.startAnimation(animation)

    }
}
package com.example.help_disaster


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.help_disaster.databinding.ActivityMainBinding
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthMissingActivityForRecaptchaException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth

    // Declare PhoneAuthProvider.OnVerificationStateChangedCallbacks instance
    private lateinit var mCallbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        binding.btnNav.setOnClickListener {
            if (binding.etuserPhone.text.toString().isEmpty()){
                binding.etuserPhone.error = "Please Enter Your Phone Number"
            } else if (binding.etuserPhone.text.toString().length != 10){
                binding.etuserPhone.error = "Please Enter 10 digits Number"
            }else{
                otpSend();
            }
        }
        val runningText = binding.runningText
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

    private fun otpSend() {

        /*binding.progressBar.visibility = android.view.View.VISIBLE*/
        binding.btnNav.visibility = android.view.View.GONE
        mCallbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            override fun onVerificationCompleted(credential: PhoneAuthCredential) {

            }

            override fun onVerificationFailed(e: FirebaseException) {
                /*binding.progressBar.visibility = android.view.View.GONE*/
                binding.otpTextInputLayout.visibility = android.view.View.GONE
                binding.btnNav.visibility = android.view.View.VISIBLE
                binding.btnNav.text = "Send OTP Again"
                Toast.makeText(this@MainActivity, e.localizedMessage, Toast.LENGTH_SHORT).show()
            }

            override fun onCodeSent(verificationId: String,
                token: PhoneAuthProvider.ForceResendingToken,
            ) {
                /*binding.progressBar.visibility = android.view.View.GONE*/
                binding.otpTextInputLayout.visibility = android.view.View.VISIBLE
                binding.btnNav.text = "Report"
                binding.btnNav.visibility = android.view.View.VISIBLE
                val intent = Intent(this@MainActivity, MenuForums::class.java)
                startActivity(intent)
            }
        }
        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber("+91"+binding.etuserPhone.text.toString().trim()) // Phone number to verify
            .setTimeout(60L, TimeUnit.SECONDS)
            .setActivity(this)
            .setCallbacks(mCallbacks)
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
    }
}
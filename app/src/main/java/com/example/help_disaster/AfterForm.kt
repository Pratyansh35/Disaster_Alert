package com.example.help_disaster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.RadioButton
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.widget.TextView
import android.widget.Toast
import com.example.help_disaster.databinding.ActivityAfterFormBinding


class AfterForm : AppCompatActivity() {
    private var a = 0
    private lateinit var uploadVideoTextView: TextView
    private val PICK_VIDEO_REQUEST = 1
    private lateinit var binding: ActivityAfterFormBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAfterFormBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // After Confirmation
        binding.btnConfirm.setOnClickListener {
            val name = binding.etDisType.text.toString()
            val phone = binding.etuserPhone.text.toString()
            val locationInfo = binding.etDetails.text.toString()

            if (name.isBlank()) {
                binding.userName.error = "Please Enter Your Name"
            } else {
                binding.userName.error = null
            }
            if (phone.isBlank()) {
                binding.userPhone.error = "Please Enter Your Name"
            } else {
                binding.userPhone.error = null
            }
            /*if (a == 0) {
                binding.RadioTV.error = "Please Select One"
            } else {
                binding.RadioTV.error = null
            }*/
            if (locationInfo.isBlank()) {
                binding.Details.error = "Please Enter Your Name"
            } else {
                binding.Details.error = null
            }
            if (name.isNotBlank() && phone.isNotEmpty() && locationInfo.isNotEmpty()) {
                Toast.makeText(this@AfterForm, "Successfully Reported Thanks A LoT", Toast.LENGTH_SHORT).show()
                val intentList = Intent(this, AfterTraining::class.java)
                startActivity(intentList)
            } else {
                Toast.makeText(this@AfterForm, "Please Fill All The Details", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        uploadVideoTextView = binding.uploadVd
        uploadVideoTextView.setOnClickListener {
            // Open the file picker
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "video/*" // Filter to only show video files
            startActivityForResult(intent, PICK_VIDEO_REQUEST)
        }
            // get reference to the string array that we just created
        val languages = resources.getStringArray(R.array.disaster_types)
        // create an array adapter and pass the required parameter
        // in our case pass the context, drop down layout , and array.
        val arrayAdapter = ArrayAdapter(this, R.layout.dropdown_item, languages)
        // get reference to the autocomplete text view
        val autocompleteTV = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)
        // set adapter to the autocomplete tv to the arrayAdapter
        autocompleteTV.setAdapter(arrayAdapter)

        fun onRadioButtonClicked(view: View) {
            if (view is RadioButton) {
                // Is the button now checked?
                val checked = view.isChecked

                // Check which radio button was clicked
                when (view.getId()) {
                    R.id.radio_pirates ->
                        if (checked) {
                            // Pirates are the best
                            a = 1;

                        }
                    R.id.radio_ninjas ->
                        if (checked) {
                            // Ninjas rule
                            a = 2;
                        }
                }
            }
        }
    }
    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_VIDEO_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
            // Handle the selected video file here
            val selectedVideoUri: Uri? = data.data
            // Now you can perform actions on the selected video, such as uploading it to a server or displaying it in your app.
        }
    }
}
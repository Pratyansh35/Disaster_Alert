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
class AfterForm : AppCompatActivity() {
    private lateinit var uploadVideoTextView: TextView
    private val PICK_VIDEO_REQUEST = 1
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_after_form)
        uploadVideoTextView = findViewById(R.id.uploadVd)

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

                        }
                    R.id.radio_ninjas ->
                        if (checked) {
                            // Ninjas rule
                        }
                }
            }
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_VIDEO_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
            // Handle the selected video file here
            val selectedVideoUri: Uri? = data.data
            // Now you can perform actions on the selected video, such as uploading it to a server or displaying it in your app.
        }
    }
}
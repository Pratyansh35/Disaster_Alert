package com.example.help_disaster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.help_disaster.databinding.ActivityAfterTrainingBinding
import androidx.recyclerview.widget.RecyclerView
class AfterTraining : AppCompatActivity() {
    private lateinit var binding: ActivityAfterTrainingBinding
    /*private lateinit var videoAdapter: VideoAdapter*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAfterTrainingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /*videoAdapter = VideoAdapter( pass your data here )
        binding.videoRecyclerView.adapter = videoAdapter*/
        binding.videoRecyclerView.layoutManager = LinearLayoutManager(this)

        // Implement a search listener on the EditText.
        binding.searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Implement your search logic here.
                val query = s.toString()
                // Update the RecyclerView with search results.
                // You may need to fetch data based on the search query.
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
    }
}
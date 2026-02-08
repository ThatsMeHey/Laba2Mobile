package com.example.laba2mobile

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var currentIndex = 0
    private lateinit var buttonPrev: Button
    private lateinit var buttonNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val imageView: ImageView = findViewById(R.id.Image)
        val titleView: TextView = findViewById(R.id.Title)
        val descView: TextView = findViewById(R.id.Description)

        buttonPrev = findViewById(R.id.leftButton)
        buttonNext = findViewById(R.id.rightButton)

        if (savedInstanceState != null) {
            currentIndex = savedInstanceState.getInt("CURRENT_INDEX_KEY", 0)
            buttonNext.isEnabled = savedInstanceState.getBoolean("BUTTON_PREVIOUS_STATE", false)
            buttonPrev.isEnabled = savedInstanceState.getBoolean("BUTTON_NEXT_STATE", true)
        }

        fun updateArtwork() {
            val artwork = artworks[currentIndex]
            imageView.setImageResource(artwork.imageRes)
            imageView.contentDescription = getString(artwork.contentDescriptionRes)
            titleView.text = getString(artwork.titleRes)
            descView.text = getString(artwork.descriptionRes)

            buttonNext.isEnabled = currentIndex < artworks.size - 1
            buttonPrev.isEnabled = currentIndex > 0
        }

        updateArtwork()

        buttonNext.setOnClickListener {
            if (currentIndex < artworks.size - 1) {
                currentIndex++
                updateArtwork()
            }
        }

        buttonPrev.setOnClickListener {
            if (currentIndex > 0) {
                currentIndex--
                updateArtwork()
            }
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("CURRENT_INDEX_KEY", currentIndex)
        outState.putBoolean("BUTTON_PREVIOUS_STATE", buttonPrev.isEnabled)
        outState.putBoolean("BUTTON_NEXT_STATE", buttonNext.isEnabled)
    }

}
package com.appninjas.beautysalonprototype.presentation.screens.photo_viewer

import android.R
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.appninjas.beautysalonprototype.databinding.ActivityViewPhotoBinding
import com.appninjas.beautysalonprototype.presentation.MainActivity
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ViewPhotoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityViewPhotoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewPhotoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }

    private fun initUI() {
        val extrasBundle: Bundle = intent.extras!!
        val imageUrl = extrasBundle.getString("imageUrl")
        Picasso.get().load(imageUrl).into(binding.resizeableImage)

        binding.closeActivityButton.setOnClickListener {
            finish()
        }
    }

  /* override fun onTouchEvent(event: MotionEvent?): Boolean {
        scaleGestureDetector.onTouchEvent(event!!)
        return true
    }

    private val onScaleGestureListener = object : SimpleOnScaleGestureListener() {

        private var factor = 0.0f

        override fun onScaleBegin(detector: ScaleGestureDetector): Boolean {
            factor = 1.0f
            return true
        }

        override fun onScale(detector: ScaleGestureDetector): Boolean {
            factor += detector.scaleFactor - 1
            binding.resizeableImage.apply {
                scaleX = factor
                scaleY = factor
            }
            return true
        }

    }

    private val scaleGestureDetector = ScaleGestureDetector()*/


}
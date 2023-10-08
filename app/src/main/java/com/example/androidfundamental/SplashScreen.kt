package com.example.androidfundamental

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class SplashScreen : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val chilloutImageView : ImageView = findViewById<ImageView>(R.id.chillout)
        chilloutImageView.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.chillout -> {
                val intent = Intent(this@SplashScreen, activityregister::class.java)
                startActivity(intent)
            }
        }
    }
}
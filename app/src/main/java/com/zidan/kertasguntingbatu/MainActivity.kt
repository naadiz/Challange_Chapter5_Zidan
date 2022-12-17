package com.zidan.kertasguntingbatu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    lateinit var ivText: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ivText = findViewById(R.id.iv_text)

        Glide.with(this)
            .load("https://i.ibb.co/HC5ZPgD/splash-screen1.png")
            .into(ivText)

        Handler().postDelayed({
            val intent = Intent(this@MainActivity, LandingActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}
package com.example.ui_practice.HomeScreen.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ui_practice.DrumkitScreen.DrumkitActivity
import com.example.ui_practice.LoginScreen.LoginScreen
import com.example.ui_practice.NewsScreen.NewsScreen
import com.example.ui_practice.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin.setOnClickListener{
            startActivity(Intent(this, LoginScreen::class.java))
        }
        btnNews.setOnClickListener{
            startActivity(Intent(this, NewsScreen::class.java))
        }
        btnDrumkit.setOnClickListener{
            startActivity(Intent(this, DrumkitActivity::class.java))
        }
    }
}
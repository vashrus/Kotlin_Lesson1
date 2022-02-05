package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class OnBordingScreen : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_bording_screen)
    }

    fun GoToSing(view: android.view.View) {
        val intent = Intent(this,SignInScreen::class.java)
        startActivity(intent)
    }


}
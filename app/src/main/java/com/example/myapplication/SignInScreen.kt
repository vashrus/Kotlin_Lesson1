package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import org.w3c.dom.Text
import java.util.regex.Pattern
import java.util.regex.Pattern.compile

class SignInScreen : AppCompatActivity() {
    lateinit var email:TextView
    lateinit var  password:TextView
    lateinit var  pattern: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in_screen)

        email = findViewById(R.id.editTextTextEmailAddress)
        password = findViewById(R.id.editTextTextPassword)
        pattern = "[a-z]{1,50}" +
                "\\@" +
                "[a-z]{1,15}" +
                "\\." +
                "[a-z]{1,8}"
    }

    fun emailValid(email:String):Boolean{
        return compile(pattern).matcher(email).matches()
    }

    fun GoToMainScreen(view: android.view.View) {
        if(email.text.isNotEmpty() && password.text.isNotEmpty())
        {
            if(emailValid(email.text.toString()))
            {
                val intent = Intent(this,Main_Screen::class.java)
                startActivity(intent)
            }
            else
            {
                val aller = AlertDialog.Builder(this).setIcon(R.drawable.icon).setTitle("Ошибка входа").setMessage("Ошибка в поле email").setPositiveButton("OK",null).create().show()
            }
        }
        else
        {
            val aller = AlertDialog.Builder(this).setIcon(R.drawable.icon).setTitle("Ошибка входа").setMessage("Пустые поля").setPositiveButton("OK",null).create().show()
        }

    }
}
package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.myapplication.Net.MyInterface
import com.example.myapplication.Net.MyRetrofit
import com.example.myapplication.Net.login
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Response
import retrofit2.create
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
                val hashMap: HashMap<String,String> = hashMapOf()
                hashMap.put("email",email.text.toString())
                hashMap.put("password",password.text.toString())

                val ret = MyRetrofit().getRetrofit()

                val inter = ret.create(MyInterface::class.java)
                val call = inter.getLogin(hashMap).enqueue(object : retrofit2.Callback<login>{
                    override fun onResponse(call: Call<login>, response: Response<login>) {
                        if(response.isSuccessful){
                            val allertDia = AlertDialog.Builder(this@SignInScreen).setTitle("Оштбка").setMessage(response.body().toString()).setPositiveButton("OK",null).create().show()
                            Toast.makeText(this@SignInScreen, response.body().toString(),Toast.LENGTH_SHORT).show()
                            val intent = Intent(this@SignInScreen,Main_Screen::class.java)
                            startActivity(intent)
                        }
                    }

                    override fun onFailure(call: Call<login>, t: Throwable) {
                        Toast.makeText(this@SignInScreen, t.localizedMessage,Toast.LENGTH_SHORT).show()
                    }

                })


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
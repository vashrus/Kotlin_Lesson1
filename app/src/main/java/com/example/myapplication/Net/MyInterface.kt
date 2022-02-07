package com.example.myapplication.Net

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface MyInterface {
    @POST("user/login")
    fun getLogin(@Body hashMap: HashMap<String,String>): Call<login>
    @GET("feelings")
    fun getFeelings():Call<feeling>
}
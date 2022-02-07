package com.example.myapplication.Net



data class login(val id:String,val email:String,val nickName:String, val avatar:String, val tokken: String)
data class feeling(val success: Boolean, val  data : List<Data>)

data class  Data(val id: Int, val title:String,val image: String,val position:Int )
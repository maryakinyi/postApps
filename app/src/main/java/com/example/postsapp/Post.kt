package com.example.postsapp

import retrofit2.http.Body

data class Post(
    var userId:Int,
    var id:Int,
    var title:String,
    var body:String
)

package com.example.postsapp.model

import retrofit2.http.Body

data class Post(
    var userId:Int,
    var id:Int,
    var title:String,
    var body:String
)

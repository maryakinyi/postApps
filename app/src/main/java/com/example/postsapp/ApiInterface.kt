package com.example.postsapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    //Getting several posts or all
    @GET("posts")//end point
    fun getPosts():Call<List<Post>>
    //getting one post post
    @GET("posts/{id}")//end point
    fun getPostById(@Path("id")postId:Int):Call<Post>

}
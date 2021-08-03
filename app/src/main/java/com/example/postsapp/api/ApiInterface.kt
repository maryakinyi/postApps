package com.example.postsapp.api

import com.example.postsapp.model.Comments
import com.example.postsapp.model.Post
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    //Getting several posts or all
    @GET("posts")//end point
    fun getPosts():Call<List<Post>>
    //getting one post post
    @GET("posts/{id}")//end point
    fun getPostById(@Path("id")postId:Int):Call<Post>
    @GET("post/{id}/comments")
    fun getComments(@Path("id")id:Int):Call<List<Comments>>
}

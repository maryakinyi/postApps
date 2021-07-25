package com.example.postsapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ApiClient {
    var retrofit=Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    //The T means that the function is generic
    fun <T>buildApiClient(apiInterface: Class<T>):T{
        return retrofit.create(apiInterface)
    }
}
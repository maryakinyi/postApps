package com.example.postsapp

import android.net.SocketKeepalive
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun getPosts(){
        var retrofit=ApiClient.buildApiClient(ApiInterface::class.java)
        var request=retrofit.getPosts()
        request.enqueue(object : Callback, retrofit2.Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response:
            Response<List<Post>>) {
                if (response.isSuccessful){
                    var posts=response.body()
                    Toast.makeText(baseContext,"${posts!!.size} post",Toast.LENGTH_LONG).show()

                }

            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {

            }

        })
    }

}
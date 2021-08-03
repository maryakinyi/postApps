package com.example.postsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.postsapp.R
import com.example.postsapp.RvPostsAdapter
import com.example.postsapp.api.ApiClient
import com.example.postsapp.api.ApiInterface
import com.example.postsapp.model.Post
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    lateinit var rvPost: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvPost.findViewById<RecyclerView>(R.id.rvPosts)
        rvPost.layoutManager=LinearLayoutManager(baseContext)
        getPosts()
            // print()
    }
    fun getPosts(){
        var retrofit= ApiClient.buildApiClient(ApiInterface::class.java)
        var request=retrofit.getPosts()
        request.enqueue(object : Callback, retrofit2.Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response:
            Response<List<Post>>) {
                if (response.isSuccessful){
                    var postList=response.body()
                    var posts=response.body()
                    if (postList!=null){
                        var postsAdapter= RvPostsAdapter(postList,baseContext)
                    rvPost.adapter=postsAdapter

                    }
//
                }

            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                  Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()

            }

        })
    }

}
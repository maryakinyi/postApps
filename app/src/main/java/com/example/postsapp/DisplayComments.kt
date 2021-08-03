package com.example.postsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.postsapp.api.ApiClient
import com.example.postsapp.api.ApiInterface
import com.example.postsapp.model.Comments
import com.example.postsapp.model.RvCommentsAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DisplayComments : AppCompatActivity() {
    var postId = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_comments)
        postId=intent.getIntExtra("postId",0)
        getComments()
    }
    fun getComments(){
        var rvComments=findViewById<RecyclerView>(R.id.RvComments)
        var apiClient=ApiClient.buildApiClient(ApiInterface::class.java)
        var request=apiClient.getComments(postId)
        request.enqueue(object:Callback<List<Comments>>{
            override fun onResponse(
                call: Call<List<Comments>>,
                response: Response<List<Comments>>
            ) {
                var commentsList=response.body()
                var commentsAdapter=RvCommentsAdapter(commentsList!!)
                rvComments.adapter=RvCommentsAdapter(commentsList)
                rvComments.layoutManager=LinearLayoutManager(baseContext)
            }

            override fun onFailure(call: Call<List<Comments>>, t: Throwable) {
                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG)
            }


        })
}
}
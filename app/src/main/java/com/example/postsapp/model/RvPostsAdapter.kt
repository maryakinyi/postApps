package com.example.postsapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.postsapp.model.Post
import com.example.postsapp.ui.MyPosts


class RvPostsAdapter(var postList: List<Post>, val context: Context):RecyclerView.Adapter<RvPostsAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
    var itemView=LayoutInflater.from(parent.context).inflate(R.layout.activity_my_posts,parent,false)
        return PostViewHolder(itemView)


}

    override fun onBindViewHolder(holder:PostViewHolder, position: Int) {
        var currentPost=postList.get(position)
        holder.tvTitle.text=currentPost.title
        holder.tvBody.text=currentPost.body
        holder.cdPost.setOnClickListener {
            var intent=Intent(context,MyPosts::class.java)
            intent.putExtra("POST_ID",currentPost.id)
            intent.putExtra("title",currentPost.title)
            intent.putExtra("body",currentPost.body)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivities(arrayOf(intent))
        }


    }

    override fun getItemCount(): Int {
        return postList.size

    }
    class PostViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    var tvTitle=itemView.findViewById<TextView>(R.id.tvTitle)
        var tvBody=itemView.findViewById<TextView>(R.id.tvBody)
        var cdPost=itemView.findViewById<TextView>(R.id.cdPosts)
    }
}

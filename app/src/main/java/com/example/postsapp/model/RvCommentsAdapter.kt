package com.example.postsapp.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.postsapp.R

class RvCommentsAdapter(var commentsList: List<Comments>) :RecyclerView.Adapter <CommentViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        var itemView=LayoutInflater.from(parent.context).inflate(R.layout.comment_list_item,parent,false)
        return CommentViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        var currentComment=commentsList.get(position)
        holder.tvEmail.text=currentComment.email
        holder.tvName.text=currentComment.name
        holder.tvCommentBody.text=currentComment.body

    }

    override fun getItemCount(): Int {
        return commentsList.size
    }
}
class CommentViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    var tvName=itemView.findViewById<TextView>(R.id.tvCommentName)
    var tvEmail=itemView.findViewById<TextView>(R.id.tvCommentEmail)
    var tvCommentBody=itemView.findViewById<TextView>(R.id.tvCommentBody)
}
package com.example.recyclerwithfragements

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.comments_row.view.*

class CommentsAdapter(val commentsList:ArrayList<Comments>):RecyclerView.Adapter<CommentsAdapter.ViewHolder>() {
    class ViewHolder(view:View):RecyclerView.ViewHolder(view) {

        val name=view.commentName as TextView
        val email=view.commentEmail as TextView
        val body=view.commentBody as TextView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsAdapter.ViewHolder {

        val inflate=  LayoutInflater.from(parent.context).inflate(R.layout.comments_row, parent, false)
        return ViewHolder(inflate)

    }

    override fun getItemCount(): Int {
        return commentsList.size
    }

    override fun onBindViewHolder(holder:ViewHolder, position: Int) {

          val commentsList:Comments=commentsList[position]
          holder.name.text=commentsList.name
          holder.email.text=commentsList.email
          holder.body.text=commentsList.body

    }
}
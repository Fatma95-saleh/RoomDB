package com.example.recyclerwithfragements

import android.os.Bundle
import android.text.TextUtils.replace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerwithfragements.database.PostsData
import kotlinx.android.synthetic.main.posts_row.view.*


class PostsAdapter(val postsList:ArrayList<PostsData>,var fragementManager:FragmentManager):RecyclerView.Adapter<PostsAdapter.ViewHolder>() {

    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {

        val title=view.postTitle as TextView
        val body=view.postBody as TextView
        val id =view.postId as TextView
        val card=view.postsCard as CardView

    }

      override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
          val inflate =
              LayoutInflater.from(parent.context).inflate(R.layout.posts_row, parent, false)
          return ViewHolder(inflate)

      }

      override fun getItemCount(): Int {

             return postsList.size
      }

      override fun onBindViewHolder(holder: ViewHolder, position: Int) {

          val postData:PostsData=postsList[position]
          holder.title.text=postData.title
          holder.body.text=postData.body

         //clock on post card to send post id to comments fragement

          holder.card.setOnClickListener {

              val bundel=Bundle()
              bundel.putInt("postId",postData.id)
              val commentsFragement=CommentsFragement()
              val postsFragement=PostsFragement()
              commentsFragement.arguments=bundel

              fragementManager.beginTransaction().replace(R.id.fragementContainer,commentsFragement).commit()


          }



      }
  }
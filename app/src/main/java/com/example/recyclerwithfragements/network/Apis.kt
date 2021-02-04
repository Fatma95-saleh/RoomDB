package com.example.recyclerwithfragements.network

import android.widget.TextView
import com.example.recyclerwithfragements.Comments
import com.example.recyclerwithfragements.Posts
import com.example.recyclerwithfragements.database.PostsData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Apis {

    @GET("posts")
    fun getData(): Call<ArrayList<PostsData>>


//    {id}
    @GET("comments")
    fun getComments(@Path ("postId") postd: Int): Call<List<Comments>>

}
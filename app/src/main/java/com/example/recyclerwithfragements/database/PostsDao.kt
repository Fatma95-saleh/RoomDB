package com.example.recyclerwithfragements.database

import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PostsDao {

    @Insert
    fun insertPosts(posts:ArrayList<PostsData>)

    @Query("SELECT * FROM posts_table")
    fun getPosts():ArrayList<PostsData>

}
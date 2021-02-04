package com.example.recyclerwithfragements.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "posts_table")
data class PostsData (

    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @ColumnInfo(name="userID")
    val userId:Int,
    @ColumnInfo(name="post_title")
    val title:String,
    @ColumnInfo(name="post_body")
    val body:String
)
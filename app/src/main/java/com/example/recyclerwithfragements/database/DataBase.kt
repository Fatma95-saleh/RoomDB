package com.example.recyclerwithfragements.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities=[PostsData::class],version = 1)
abstract class DataBase : RoomDatabase(){

    abstract fun PostsDao():PostsDao

}
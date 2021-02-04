package com.example.recyclerwithfragements.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.recyclerwithfragements.MvvMApp

 object DataBaseBuilder{

        @Volatile
        private var instance:DataBase?=null

        fun getDataBase():DataBase?{

            if (instance==null){

                synchronized(DataBase::class.java){


                        instance= Room.databaseBuilder(MvvMApp.applicationContext(),
                            DataBase::class.java,"database")
                            .allowMainThreadQueries().build()

                }
            }

            return instance

        }

    }


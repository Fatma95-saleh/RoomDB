package com.example.recyclerwithfragements

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Appear postsFragement first

         val postsFragement=PostsFragement()
         val commentsFragement=CommentsFragement()

         supportFragmentManager.beginTransaction().apply {

            replace(R.id.fragementContainer,postsFragement)
             commit()

         }

    }
}
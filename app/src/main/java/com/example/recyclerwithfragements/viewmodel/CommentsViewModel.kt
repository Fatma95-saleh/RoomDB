package com.example.recyclerwithfragements.viewmodel

import android.util.Log
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recyclerwithfragements.Comments
import com.example.recyclerwithfragements.network.NetworkManger
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentsViewModel: ViewModel() {

      lateinit var commentsData:MutableLiveData<List<Comments>>

    init {
        commentsData= MutableLiveData()
    }

    fun getRecyclerListDataObserver(): MutableLiveData<List<Comments>> {

        return  commentsData

    }

    fun makeApiCall(postId: Int) {

        //     fun featchData(){

        NetworkManger.retrofitConnection().getComments(postId).enqueue(object: Callback<List<Comments>> {
            override fun onFailure(call: Call<List<Comments>>, t: Throwable) {
//                Log.e("err", t.message!!)

            }

            override fun onResponse(
                call: Call<List<Comments>>,
                response: Response<List<Comments>>
            ) {
//                Log.e("connection state", response.body().toString())
                // arrData.addAll(response.body()!!)
                commentsData.postValue(response.body()!!)
            }


        })
        //   }

    }

}

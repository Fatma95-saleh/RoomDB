package com.example.recyclerwithfragements.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recyclerwithfragements.database.DataBaseBuilder
import com.example.recyclerwithfragements.database.PostsData
import com.example.recyclerwithfragements.network.NetworkManger.Companion.retrofitConnection
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostsViewModel: ViewModel() {

    var recyclerListData: MutableLiveData<ArrayList<PostsData>> = MutableLiveData()
    var postId:Int = 0

    init {
        recyclerListData= MutableLiveData()
        getPostsOffline()
    }


    fun getRecyclerListDataObserver(): MutableLiveData<ArrayList<PostsData>> {

        return  recyclerListData

    }

    //insert data in room data base
     var recyclerRoomData: MutableLiveData<ArrayList<PostsData>> = MutableLiveData()



    fun getPostsOffline(){
        recyclerRoomData.postValue(DataBaseBuilder.getDataBase()?.PostsDao()?.getPosts())
    }

    fun getRoomDataObserver(): MutableLiveData<ArrayList<PostsData>> {

        return  recyclerRoomData

    }

    fun makeApiCall(){

        //     fun featchData(){



        retrofitConnection().getData().enqueue(object: Callback<ArrayList<PostsData>> {

            override fun onResponse(
                call: Call<ArrayList<PostsData>>, response: Response<ArrayList<PostsData>>
            ) {

                Log.e("connection state", response.body().toString())
                // arrData.addAll(response.body()!!)

                recyclerListData.postValue(response.body()!!)


                //data from room
                DataBaseBuilder.getDataBase()?.PostsDao()?.insertPosts(response.body()!!)
                recyclerRoomData.postValue(response.body()!!)

            }
            override fun onFailure(call: Call<ArrayList<PostsData>>, t: Throwable) {
                Log.e("err", t.message!!)
            }
        })
        //   }

    }


}
package com.example.recyclerwithfragements

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerwithfragements.database.PostsData
import com.example.recyclerwithfragements.viewmodel.PostsViewModel


class PostsFragement : Fragment() {

    lateinit var postsRecycler:RecyclerView
    lateinit var postsAdapter:PostsAdapter
    val postsArray:ArrayList<PostsData> = ArrayList()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_posts_fragement, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        postsArray.add(Posts(1,1,"hhhf","fk"))
//        postsArray.add(Posts(1,1,"hhhf","fk"))
//        postsArray.add(Posts(1,1,"hhhf","fk"))
//


        initViews(view)
        featchDataMvvm()
        featchDataFromRoom()

    }


    fun initViews(view:View){

        postsRecycler=view.findViewById(R.id.postsRecycler)
        postsRecycler.layoutManager=LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)
        postsAdapter=activity?.supportFragmentManager?.let {
            PostsAdapter(postsArray,it)
        }!!
        postsRecycler.adapter=postsAdapter


    }

    fun featchDataMvvm(){

        var viewModel= ViewModelProviders.of(this).get(PostsViewModel::class.java)
        viewModel.getRecyclerListDataObserver().observe(viewLifecycleOwner, Observer <ArrayList<PostsData>>{

            if(it!==null){

                postsArray.addAll(it)
                postsAdapter.notifyItemRangeInserted(postsArray.size + 1 ,it.size!!)

//                Log.e("success", it.toString())
            }

        })
        viewModel.makeApiCall()
    }

    fun featchDataFromRoom(){

        var viewModel= ViewModelProviders.of(requireActivity()).get(PostsViewModel::class.java)
        viewModel.recyclerRoomData.observe(viewLifecycleOwner, Observer <ArrayList<PostsData>>{
0
            if(it!==null){

                postsArray.addAll(it)
                postsAdapter.notifyItemRangeInserted(postsArray.size + 1 ,it.size!!)

//                Log.e("success", it.toString())
            }

        })
        viewModel.makeApiCall()
    }



    }

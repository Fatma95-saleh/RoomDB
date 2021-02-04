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
import com.example.recyclerwithfragements.viewmodel.CommentsViewModel
import kotlinx.android.synthetic.main.posts_row.*


class CommentsFragement : Fragment() {

    lateinit var commentsRecycler:RecyclerView
    lateinit var commentsAdapter: CommentsAdapter
    val commentsData:ArrayList<Comments> = ArrayList()
    var postID = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_comments_fragement, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        coomentsDta.add(Comments(1,1,"hhhf","fk","khh"))
//        coomentsDta.add(Comments(1,1,"hhhf","fk","khh"))
//        coomentsDta.add(Comments(1,1,"hhhf","fk","khh"))



    }

    override fun onStart() {
        super.onStart()


        initviews()
        featchDataMvvm()
    }

    fun initviews(){
        commentsRecycler.layoutManager=LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)

        val support=activity?.supportFragmentManager

        commentsAdapter= CommentsAdapter(commentsData)//////???????????????
        commentsRecycler.adapter=commentsAdapter

    }

    fun featchDataMvvm(){
//        if(arguments!=null&& arguments!!.containsKey("postId")){
//
//            postID = arguments!!.getInt("postId")
//        }
        var viewModel= ViewModelProviders.of(this).get(CommentsViewModel::class.java)
        viewModel.getRecyclerListDataObserver().observe(viewLifecycleOwner, Observer <List<Comments>>{

            if(it!==null){

//                commentsData.addAll(it)
//                commentsAdapter.notifyItemRangeInserted(commentsData.size + 1 ,it.size!!)

//                Log.e("success", it.toString())
            }

        })
        viewModel.makeApiCall(postID)
    }





}

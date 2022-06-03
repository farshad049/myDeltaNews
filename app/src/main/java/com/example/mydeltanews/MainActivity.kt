package com.example.mydeltanews

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mydeltanews.databinding.ActivityMainBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityMainBinding=
            DataBindingUtil.setContentView(this,R.layout.activity_main)

        val viewModel: NewsFeedViewModel= ViewModelProvider(this)[NewsFeedViewModel::class.java]

        //this is for data binding
        binding.lifecycleOwner=this
        binding.viewModel=viewModel

        //take the data
        viewModel.fetch()

        val recyclerViewAdapter=NewsFeedAdapter()
        binding.recyclerView.adapter=recyclerViewAdapter

        viewModel.newsFeedLiveData.observe(this){
            recyclerViewAdapter.setItems(it)
        }



















    }//FUN





}
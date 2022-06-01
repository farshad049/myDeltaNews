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


        binding.lifecycleOwner=this
        binding.viewModel=viewModel


        // Write a message to the database
//        val database = Firebase.database
//        val myRef = database.getReference("message")
//
//        // Read from the database
//        myRef.addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(dataSnapshot: DataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//                Log.i("SNAPSHOT",dataSnapshot.value.toString())
//
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                // Failed to read value
//
//            }
//        })
















    }//FUN





}
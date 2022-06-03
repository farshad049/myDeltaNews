package com.example.mydeltanews

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.mydeltanews.model.NewsFeedModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class NewsFeedRepository {


    val database = Firebase.database
    val myRef = database.getReference("new_feed")


    fun fetchNews(liveData:MutableLiveData<List<NewsFeedModel>>){
        myRef
            .orderByChild("_rank")
            .addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Log.i("SNAPSHOT",dataSnapshot.value.toString())

                val newsFeedItems:List<NewsFeedModel> = dataSnapshot.children.map {
                    it.getValue(NewsFeedModel::class.java)!!
                }
                Log.i("ITEM",newsFeedItems.toString())
                liveData.postValue(newsFeedItems)

            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
            }
        })
    }





}
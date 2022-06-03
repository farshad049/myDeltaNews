package com.example.mydeltanews

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mydeltanews.model.NewsFeedModel

class NewsFeedViewModel:ViewModel() {

    val repository=NewsFeedRepository()

    private val _newsFeedLiveData=MutableLiveData<List<NewsFeedModel>>()
    val newsFeedLiveData:LiveData<List<NewsFeedModel>> =_newsFeedLiveData

    fun fetch(){
        repository.fetchNews(_newsFeedLiveData)
    }
}

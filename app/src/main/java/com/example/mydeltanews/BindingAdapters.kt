package com.example.mydeltanews

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mydeltanews.model.NewsFeedModel

//set data for recycler view by dataBinding modo
@BindingAdapter("setItemsByFarhad")
fun setItems(recyclerView: RecyclerView, list: List<NewsFeedModel>?){
    (recyclerView.adapter as NewsFeedAdapter).setItems(list)
}
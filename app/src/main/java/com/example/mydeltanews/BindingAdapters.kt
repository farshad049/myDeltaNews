package com.example.mydeltanews

import android.webkit.WebView
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mydeltanews.main.NewsFeedAdapter
import com.example.mydeltanews.model.NewsFeedModel
import com.squareup.picasso.Picasso

//set data for recycler view by dataBinding modo
@BindingAdapter("setItemsByFarhad")
fun setItems(recyclerView: RecyclerView, list: List<NewsFeedModel>?){
    (recyclerView.adapter as NewsFeedAdapter).setItems(list)
}

@BindingAdapter("loadWithPicasso")
fun loadPicasso(imageView: ImageView,imageUrl:String){
    Picasso.get().load(imageUrl).into(imageView)
}

@BindingAdapter("loadImageUrl")
fun loadImageUrl(webView:WebView,url:String){
    webView.loadUrl(url)
}
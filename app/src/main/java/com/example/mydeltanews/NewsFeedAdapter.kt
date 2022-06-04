package com.example.mydeltanews

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mydeltanews.databinding.NewsItemBinding
import com.example.mydeltanews.model.NewsFeedModel
import com.squareup.picasso.Picasso

class NewsFeedAdapter(private val onItemClick:(String) -> Unit):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val newsItem= mutableListOf<NewsFeedModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return NewsFeedItemViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as NewsFeedItemViewHolder).onBind(newsItem[position],onItemClick)
    }

    override fun getItemCount(): Int {
        return newsItem.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(newsFeedItem:List<NewsFeedModel>?){
        newsItem.clear()
        newsItem.addAll(newsFeedItem ?: emptyList())
        notifyDataSetChanged()
    }



    inner class NewsFeedItemViewHolder(parent: ViewGroup):RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.news_item,parent,false)
    ){
        private val binding=NewsItemBinding.bind(itemView)
        //newsFeedItem is implementing in activity_main.xml because of dataBinding
        fun onBind(newsFeedItem:NewsFeedModel,onclick:(String)->Unit){
            binding.imageUrl=newsFeedItem.image_url
            binding.title=newsFeedItem.title
            binding.descriptions=newsFeedItem.description
            binding.source=newsFeedItem.source
            binding.published=newsFeedItem.published
            binding.root.setOnClickListener {
                onclick(newsFeedItem.url)
            }
        }

    }
}
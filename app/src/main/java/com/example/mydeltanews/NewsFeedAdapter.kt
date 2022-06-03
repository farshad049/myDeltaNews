package com.example.mydeltanews

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mydeltanews.databinding.NewsItemBinding
import com.example.mydeltanews.model.NewsFeedModel

class NewsFeedAdapter:RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val newsItem= mutableListOf<NewsFeedModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return NewsFeedItemViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as NewsFeedItemViewHolder).onBind(newsItem[position])
    }

    override fun getItemCount(): Int {
        return newsItem.size
    }

    fun setItems(newsFeedItem:List<NewsFeedModel>){
        newsItem.clear()
        newsItem.addAll(newsFeedItem)
        notifyDataSetChanged()
    }



    inner class NewsFeedItemViewHolder(parent: ViewGroup):RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.news_item,parent,false)
    ){
        private val binding=NewsItemBinding.bind(itemView)

        fun onBind(newsFeedItem:NewsFeedModel){
            binding.tvTitle.text=newsFeedItem.title
            binding.tvDescription.text=newsFeedItem.description
        }

    }
}
package com.example.mydeltanews.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mydeltanews.R
import com.example.mydeltanews.databinding.NewsItemBinding
import com.example.mydeltanews.model.NewsFeedModel
import java.lang.ref.WeakReference

class NewsFeedAdapter(private val onItemClick:OnClickInterface):RecyclerView.Adapter<RecyclerView.ViewHolder>() {




    private val newsItem= mutableListOf<NewsFeedModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return NewsFeedItemViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as NewsFeedItemViewHolder).onBind(
            newsItem[position],
            onItemClick

        )
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
        fun onBind(newsFeedItem:NewsFeedModel, onClick:OnClickInterface){
            binding.imageUrl=newsFeedItem.image_url
            binding.title=newsFeedItem.title
            binding.descriptions=newsFeedItem.description
            binding.source=newsFeedItem.source
            binding.published=newsFeedItem.published
            binding.root.setOnClickListener {
                onClick.onItemClicked(newsFeedItem.url)
            }

            val drawableResId: Int = if (newsFeedItem.favorite) {
                R.drawable.ic_favorite_24
            } else {
                R.drawable.ic_favorite_outline_24
            }
            binding.favorite.setImageResource(drawableResId)
            binding.favorite.setOnClickListener {
                val newStatus= !newsFeedItem.favorite
                onClick.onFavoriteClicked(newsFeedItem.id,newStatus)
            }
        }

    }
}

interface OnClickInterface {
    fun onItemClicked(url:String)
    fun onFavoriteClicked(newsFeedItemId:String,isFavorite:Boolean)
}



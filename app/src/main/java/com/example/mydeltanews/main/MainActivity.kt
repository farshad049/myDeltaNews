package com.example.mydeltanews.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mydeltanews.detail.DetailActivity
import com.example.mydeltanews.NewsFeedViewModel
import com.example.mydeltanews.R
import com.example.mydeltanews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),OnClickInterface {

    private val viewModel: NewsFeedViewModel by lazy {
        ViewModelProvider(this)[NewsFeedViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityMainBinding=
            DataBindingUtil.setContentView(this, R.layout.activity_main)



        //this is for data binding
        binding.lifecycleOwner=this
        binding.viewModel=viewModel

        //take the data
        viewModel.fetch()

        val recyclerViewAdapter= NewsFeedAdapter(this)
        binding.recyclerView.adapter=recyclerViewAdapter

//        viewModel.newsFeedLiveData.observe(this){
//            recyclerViewAdapter.setItems(it)
//        }





    }//FUN



    override fun onItemClicked(url: String) {
        val intent=Intent(this, DetailActivity::class.java).apply {
            putExtra("link",url)
        }
        startActivity(intent)
    }

    override fun onFavoriteClicked(id: String, isFavorite: Boolean) {
        viewModel.updateIsFavoriteStatus(id,isFavorite)
    }
}


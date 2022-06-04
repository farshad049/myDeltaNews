package com.example.mydeltanews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.mydeltanews.databinding.ActivityDetailBinding
import com.example.mydeltanews.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityDetailBinding=
            DataBindingUtil.setContentView(this,R.layout.activity_detail)

        val url=intent.getStringExtra("link") ?: ""

        binding.url=url

    }
}
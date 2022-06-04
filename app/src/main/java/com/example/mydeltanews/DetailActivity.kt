package com.example.mydeltanews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.databinding.DataBindingUtil
import com.example.mydeltanews.databinding.ActivityDetailBinding
import com.example.mydeltanews.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityDetailBinding=
            DataBindingUtil.setContentView(this,R.layout.activity_detail)



        // WebViewClient is a class to take care of loading state fot web pages
        val client=object : WebViewClient(){
            override fun onPageFinished(view: WebView?, url: String?) {
                binding.progressBar.hide()
            }
        }
        //set the client object for web view
        binding.webView.webViewClient=client

        //take data from intent
        val url=intent.getStringExtra("link") ?: ""
        binding.url=url



    }//FUN
}
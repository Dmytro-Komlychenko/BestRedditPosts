package com.example.bestredditposts.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.bestredditposts.app.App
import com.example.bestredditposts.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        (applicationContext as App).appComponent.inject(this)
        viewModel = ViewModelProvider(this, mainViewModelFactory)[MainViewModel::class.java]

    }

    override fun onStart() {
        super.onStart()
        viewModel.liveDataPost.observe(this) {

            binding.textView1.text = it.authorFullname
            binding.textView2.setText(it.thumbnail)
            binding.textView3.text = it.approvedAtUtc.toString()
            binding.textView4.text = it.commentsCount.toString()
        }
        viewModel.getPosts()
    }
}
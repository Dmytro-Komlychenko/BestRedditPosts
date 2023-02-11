package com.example.bestredditposts.presentation.fullScreen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.bestredditposts.databinding.ActivityFullScreenImageBinding
import com.example.bestredditposts.presentation.postList.FullScreenImageKey
import com.squareup.picasso.Picasso

class FullScreenImageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFullScreenImageBinding
    private lateinit var viewModel: FullScreenImageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFullScreenImageBinding.inflate(layoutInflater)

        viewModel = ViewModelProvider(this)[FullScreenImageViewModel::class.java]

        viewModel.imageLink.value = intent.getStringExtra(FullScreenImageKey)

        Picasso.get()
            .load(viewModel.imageLink.value)
            .into(binding.image)

        binding.image.setOnClickListener {
            onBackPressed()
        }

        setContentView(binding.root)
    }


}
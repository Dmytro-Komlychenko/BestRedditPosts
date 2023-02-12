package com.example.bestredditposts.presentation.fullScreen

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.bestredditposts.R
import com.example.bestredditposts.databinding.ActivityFullScreenImageBinding
import com.example.bestredditposts.presentation.postList.PostItemAdapter
import com.example.bestredditposts.utils.ImageDownloader
import com.squareup.picasso.Picasso

class FullScreenImageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFullScreenImageBinding
    private lateinit var viewModel: FullScreenImageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFullScreenImageBinding.inflate(layoutInflater)

        viewModel = ViewModelProvider(this)[FullScreenImageViewModel::class.java]

        viewModel.imageLink.value = intent.getStringExtra(PostItemAdapter.FULL_SCREEN_IMAGE_CONST)

        Picasso.get()
            .load(viewModel.imageLink.value)
            .into(binding.image)

        binding.image.setOnLongClickListener {
            if (binding.moreView.visibility == View.GONE)
                binding.moreView.visibility = View.VISIBLE
            else if (binding.moreView.visibility == View.VISIBLE)
                binding.moreView.visibility = View.GONE

            return@setOnLongClickListener true
        }

        binding.moreView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.btnDownloadImage -> ImageDownloader.downloadImageIntoGallery(this, binding.image)
                else -> true
            }
        }

        binding.image.setOnClickListener {
            onBackPressed()
        }

        setContentView(binding.root)
    }


}
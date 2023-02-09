package com.example.bestredditposts.presentation.postList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.bestredditposts.databinding.FragmentPostListBinding
import com.example.bestredditposts.presentation.main.MainViewModel

class PostItemFragment : Fragment() {

    private lateinit var binding: FragmentPostListBinding
    val viewModel: MainViewModel by activityViewModels()
    lateinit var adapter: PostItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPostListBinding.inflate(layoutInflater)

        viewModel.liveDataPost.observe(viewLifecycleOwner) {
            adapter = PostItemAdapter(it)
            binding.recyclerView.adapter = adapter
        }

        return binding.root
    }


}
package com.example.bestredditposts.presentation.postList

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.bestredditposts.databinding.FragmentPostListBinding
import com.example.bestredditposts.presentation.main.MainViewModel
import kotlinx.coroutines.launch

class PostItemFragment : Fragment() {

    private lateinit var binding: FragmentPostListBinding
    private val viewModel: MainViewModel by activityViewModels()
    lateinit var adapter: PostItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPostListBinding.inflate(layoutInflater)

        adapter = PostItemAdapter(requireContext())
        binding.recyclerView.adapter = adapter

        viewModel.errorMessage.observe(viewLifecycleOwner) {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        }

        lifecycleScope.launch {
            viewModel.getPostList().observe(viewLifecycleOwner) {
                it?.let {
                    adapter.submitData(lifecycle, it)
                }
            }
        }

        return binding.root
    }


}
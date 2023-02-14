package com.example.bestredditposts.presentation.postList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.bestredditposts.databinding.FragmentPostListBinding
import com.example.bestredditposts.presentation.main.MainViewModel
import com.example.bestredditposts.presentation.noInternet.InternetConnectionCheck
import kotlinx.coroutines.launch

class PostsFragment : Fragment() {

    private lateinit var binding: FragmentPostListBinding
    private val viewModel: MainViewModel by activityViewModels()
    lateinit var adapter: PostItemAdapter



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPostListBinding.inflate(layoutInflater)

        viewModel.errorMessage.observe(viewLifecycleOwner) {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        }

        binding.recyclerView.adapter?.stateRestorationPolicy =  RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY

        adapter = PostItemAdapter(requireContext())
        binding.recyclerView.adapter = adapter

        if (viewModel.posts.value != null) {
            adapter.submitData(lifecycle, viewModel.posts.value!!)
        }

        refreshList()

        viewModel.updatePosts.observe(viewLifecycleOwner) {
            if (it) {
                refreshList()
                viewModel.updatePosts.value = false
            }
        }

        return binding.root
    }


    private fun refreshList() {
        lifecycleScope.launch {
            viewModel.getPostList().observe(viewLifecycleOwner) {
                if (InternetConnectionCheck.isOnline(requireContext())) {
                    it?.let {
                        adapter = PostItemAdapter(requireContext())
                        binding.recyclerView.adapter = adapter
                        adapter.submitData(lifecycle, it)
                        viewModel.posts.value = it
                    }
                }
            }
        }

    }

}
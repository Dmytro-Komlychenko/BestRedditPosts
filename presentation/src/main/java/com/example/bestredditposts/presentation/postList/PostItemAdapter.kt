package com.example.bestredditposts.presentation.postList

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.example.bestredditposts.databinding.FragmentPostItemBinding

import com.example.domain.model.Post

class PostItemAdapter(
    private val posts: ArrayList<Post?>
) : RecyclerView.Adapter<PostItemAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(FragmentPostItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        posts[position]?.let { holder.bind(it) }
    }

    override fun getItemCount(): Int = posts.size



    inner class ViewHolder(private val binding: FragmentPostItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(post: Post) {
            binding.tvId.text = post.id.toString()
            binding.tvAuthorName.text = post.authorFullname
            binding.etThumbnailLink.setText(post.thumbnail)
            binding.tvApprovedAtUtc.text = post.approvedAtUtc.toString()
            binding.tvCommentsCount.text = post.commentsCount.toString()

        }
    }

}
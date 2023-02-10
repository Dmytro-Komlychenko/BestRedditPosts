package com.example.bestredditposts.presentation.postList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bestredditposts.databinding.FragmentPostItemBinding
import com.example.domain.model.Post
import com.example.domain.utils.NumberConverter
import com.example.domain.utils.TimeConverter
import com.squareup.picasso.Picasso

class PostItemAdapter(
    private val posts: ArrayList<Post?>
) : RecyclerView.Adapter<PostItemAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            FragmentPostItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        posts[position]?.let { holder.bind(it) }
    }

    override fun getItemCount(): Int = posts.size



    inner class ViewHolder(private val binding: FragmentPostItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(post: Post) {
            binding.tvAuthorName.text = post.authorName
            binding.tvCountHours.text = TimeConverter.convertUNIXtoHoursAgo(post.hoursAgo)
            binding.tvTitle.text = post.title
            binding.btnLikes.text = NumberConverter.convertNumberToShortFormat(post.commentsCount)
            binding.btnComments.text = post.commentsCount.toString()

            Picasso.get()
                .load(post.thumbnail)
                .resize(post.thumbnailWidth ?: 0, post.thumbnailHeight ?: 0)
                .into(binding.image);
        }
    }

}
package com.example.bestredditposts.presentation.postList

import android.app.Activity
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.util.Pair
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bestredditposts.databinding.FragmentPostItemBinding
import com.example.bestredditposts.presentation.fullScreen.FullScreenImageActivity
import com.example.domain.model.Post
import com.example.domain.utils.NumberConverter
import com.example.domain.utils.TimeConverter
import com.squareup.picasso.Picasso

const val FullScreenImageKey = "FullScreenImageKey"
const val ImageKey = "ImageKey"

class PostItemAdapter(
    private val posts: ArrayList<Post?>,
    private val context: Context
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
                //.resize(post.thumbnailWidth ?: 0, post.thumbnailHeight ?: 0)
                .into(binding.image)

            binding.image.setOnClickListener {
                //запускаем активити и отдаем ей post.thumbnail
                val intent = Intent(context, FullScreenImageActivity::class.java)

                val options = ActivityOptions.makeSceneTransitionAnimation(
                    context as Activity,
                    Pair(binding.image, ImageKey)
                )

                intent.putExtra(FullScreenImageKey, post.thumbnail)
                context.startActivity(intent, options.toBundle())
            }
        }
    }

}
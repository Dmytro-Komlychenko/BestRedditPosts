package com.example.bestredditposts.presentation.postList

import android.app.Activity
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.util.Log
import android.util.Pair
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.children
import androidx.recyclerview.widget.RecyclerView
import com.example.bestredditposts.R
import com.example.bestredditposts.databinding.FragmentPostItemBinding
import com.example.bestredditposts.presentation.fullScreen.FullScreenImageActivity
import com.example.bestredditposts.utils.ImageDownloader
import com.example.domain.model.Post
import com.example.domain.utils.NumberConverter
import com.example.domain.utils.TimeConverter
import com.squareup.picasso.Picasso


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

            binding.image.setAspectRatio(post.thumbnailWidth ?: 0, post.thumbnailHeight ?: 0)

            Picasso.get()
                .load(post.thumbnail)
                .into(binding.image)

            binding.image.setOnClickListener {
                val intent = Intent(context, FullScreenImageActivity::class.java)

                val options = ActivityOptions.makeSceneTransitionAnimation(
                    context as Activity,
                    Pair(binding.image, IMAGE_TRANSITION_ANIMATION_CONST)
                )

                intent.putExtra(FULL_SCREEN_IMAGE_CONST, post.thumbnail)
                context.startActivity(intent, options.toBundle())
                hideMoreMenu(it)
            }

            binding.btnMore.setOnClickListener {
                if (binding.moreView.visibility == View.GONE) {
                    binding.moreView.visibility = View.VISIBLE
                    Log.i("hideMoreMenu", "View.GONE")
                } else if (binding.moreView.visibility == View.VISIBLE) {
                    binding.moreView.visibility = View.GONE
                    Log.i("hideMoreMenu", "View.GONE")
                }
                hideMoreMenu(it)
            }


            binding.moreView.setNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.btnDownloadImage -> ImageDownloader.downloadImageIntoGallery(
                        context,
                        binding.image
                    )
                    else -> true
                }
            }

            onHideMoreMenu(binding.postLayout)
        }

        private fun onHideMoreMenu(view: View) {
            if (!view.hasOnClickListeners()) {
                view.setOnClickListener {
                    hideMoreMenu(view)
                }
            }
            if (view is ViewGroup)
                (view).children.forEach { onHideMoreMenu(it) }
        }


        private fun hideMoreMenu(view: View) {
            if (view.id != binding.btnMore.id) binding.moreView.visibility = View.GONE
        }
    }


    companion object {
        const val FULL_SCREEN_IMAGE_CONST = "FullScreenImageConst"
        const val IMAGE_TRANSITION_ANIMATION_CONST = "ImageTransitionAnimationConst"
    }

}





















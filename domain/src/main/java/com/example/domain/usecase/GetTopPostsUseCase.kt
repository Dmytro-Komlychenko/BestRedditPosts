package com.example.domain.usecase

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.example.domain.model.Post
import com.example.domain.repositoryI.RedditRepository

class GetTopPostsUseCase(private val redditRepository: RedditRepository) {
    fun execute(): LiveData<PagingData<Post>> {
        return redditRepository.getTopPosts()
    }
}

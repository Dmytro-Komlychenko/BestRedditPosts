package com.example.domain.usecase

import com.example.domain.model.Post
import com.example.domain.repositoryI.RedditRepository

class GetTopPostsUseCase(private val redditRepository: RedditRepository) {
    suspend fun execute(): Post? {
        return redditRepository.getTopPosts()
    }
}

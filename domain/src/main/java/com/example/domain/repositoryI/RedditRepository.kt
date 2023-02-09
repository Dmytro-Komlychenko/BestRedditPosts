package com.example.domain.repositoryI

import com.example.domain.model.Post

interface RedditRepository {
    suspend fun getTopPosts(): Post?
}